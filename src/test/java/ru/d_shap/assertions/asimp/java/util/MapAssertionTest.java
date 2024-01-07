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

import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

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
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap());

        try {
            initializeWithRawActual(Raw.<String, String>mapAssertion(), new Object());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Map> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.<String, String>mapAssertion(), new Object(), "Message");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Map> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isEmpty();
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isNotNull().isEmpty().isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().isEmpty();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).isEmpty();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").isEmpty();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value")).isEmpty();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<{key=value}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value"), "Message").isEmpty();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<{key=value}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isNullOrEmpty();
        initialize(Raw.<String, String>mapAssertion(), null).isNullOrEmpty();
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isNotNull().isNullOrEmpty().isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().isNullOrEmpty();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value")).isNullOrEmpty();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<{key=value}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value"), "Message").isNullOrEmpty();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<{key=value}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value")).isNotEmpty();
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value")).isNotNull().isNotEmpty().isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().isNotEmpty();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).isNotEmpty();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").isNotEmpty();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isNotEmpty();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap(), "Message").isNotEmpty();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.<String, String>mapAssertion(), null).isEqualTo(null);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isEqualTo(DataHelper.<String, String>createHashMap());
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value")).isEqualTo(DataHelper.createHashMap("key", "value"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "val1", "key2", "val2")).isEqualTo(DataHelper.createHashMap("key1", "val1", "key2", "val2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap(null, null, "key1", "val1", "key2", "val2")).isEqualTo(DataHelper.createHashMap(null, null, "key1", "val1", "key2", "val2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "val1", null, null, "key2", "val2")).isEqualTo(DataHelper.createHashMap("key1", "val1", null, null, "key2", "val2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "val1", "key2", "val2", null, null)).isEqualTo(DataHelper.createHashMap("key1", "val1", "key2", "val2", null, null));
        initialize(Raw.<String, Float>mapAssertion(), DataHelper.createHashMap("key1", Float.NaN, "key2", Float.POSITIVE_INFINITY, "key3", Float.NEGATIVE_INFINITY, "key4", 3.0f)).isEqualTo(DataHelper.createHashMap("key1", Float.NaN, "key2", Float.POSITIVE_INFINITY, "key3", Float.NEGATIVE_INFINITY, "key4", 3.0f));
        initialize(Raw.<String, Double>mapAssertion(), DataHelper.createHashMap("key1", Double.NaN, "key2", Double.POSITIVE_INFINITY, "key3", Double.NEGATIVE_INFINITY, "key4", 3.0)).isEqualTo(DataHelper.createHashMap("key1", Double.NaN, "key2", Double.POSITIVE_INFINITY, "key3", Double.NEGATIVE_INFINITY, "key4", 3.0));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value")).isNotNull().isEqualTo(DataHelper.createHashMap("key", "value")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().isEqualTo(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).isEqualTo(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").isEqualTo(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isEqualTo(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap(), "Message").isEqualTo(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value")).isEqualTo(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<{key=value}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value"), "Message").isEqualTo(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<{key=value}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value")).isEqualTo(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<EMPTY>> but was:<{key=value}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value"), "Message").isEqualTo(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<EMPTY>> but was:<{key=value}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isEqualTo(DataHelper.createHashMap("key", "value"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<{key=value}> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap(), "Message").isEqualTo(DataHelper.createHashMap("key", "value"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<{key=value}> but was:<<EMPTY>>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.<String, String>mapAssertion(), null).isNotEqualTo(DataHelper.<String, String>createHashMap());
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isNotEqualTo(null);
        initialize(Raw.<String, String>mapAssertion(), null).isNotEqualTo(DataHelper.createHashMap("key", "value"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value")).isNotEqualTo(null);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isNotEqualTo(DataHelper.createHashMap("key", "value"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key", "value")).isNotEqualTo(DataHelper.<String, String>createHashMap());
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "val1")).isNotEqualTo(DataHelper.createHashMap("key2", "val2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "val1", "key2", "val2")).isNotEqualTo(DataHelper.createHashMap(null, null, "key1", "val1", "key2", "val2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "val1", "key2", "val2")).isNotEqualTo(DataHelper.createHashMap("key1", "val1", null, null, "key2", "val2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "val1", "key2", "val2")).isNotEqualTo(DataHelper.createHashMap("key1", "val1", "key2", "val2", null, null));
        initialize(Raw.<String, Integer>mapAssertion(), DataHelper.createHashMap("key1", 5, "key2", 10)).isNotEqualTo(DataHelper.createHashMap("key1", 15, "key2", 20));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "val1")).isNotNull().isNotEqualTo(DataHelper.createHashMap("key2", "val2")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().isNotEqualTo(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).isNotEqualTo(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isNotEqualTo(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap(), "Message").isNotEqualTo(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "val1", "key2", "val2")).isNotEqualTo(DataHelper.createHashMap("key1", "val1", "key2", "val2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<{key1=val1, key2=val2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "val1", "key2", "val2"), "Message").isNotEqualTo(DataHelper.createHashMap("key1", "val1", "key2", "val2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<{key1=val1, key2=val2}>");
        }
        try {
            initialize(Raw.<String, Float>mapAssertion(), DataHelper.createHashMap("key1", Float.NaN, "key2", Float.POSITIVE_INFINITY, "key3", Float.NEGATIVE_INFINITY)).isNotEqualTo(DataHelper.createHashMap("key1", Float.NaN, "key2", Float.POSITIVE_INFINITY, "key3", Float.NEGATIVE_INFINITY));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<{key1=NaN, key2=Infinity, key3=-Infinity}>");
        }
        try {
            initialize(Raw.<String, Float>mapAssertion(), DataHelper.createHashMap("key1", Float.NaN, "key2", Float.POSITIVE_INFINITY, "key3", Float.NEGATIVE_INFINITY), "Message").isNotEqualTo(DataHelper.createHashMap("key1", Float.NaN, "key2", Float.POSITIVE_INFINITY, "key3", Float.NEGATIVE_INFINITY));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<{key1=NaN, key2=Infinity, key3=-Infinity}>");
        }
        try {
            initialize(Raw.<String, Double>mapAssertion(), DataHelper.createHashMap("key1", Double.NaN, "key2", Double.POSITIVE_INFINITY, "key3", Double.NEGATIVE_INFINITY)).isNotEqualTo(DataHelper.createHashMap("key1", Double.NaN, "key2", Double.POSITIVE_INFINITY, "key3", Double.NEGATIVE_INFINITY));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<{key1=NaN, key2=Infinity, key3=-Infinity}>");
        }
        try {
            initialize(Raw.<String, Double>mapAssertion(), DataHelper.createHashMap("key1", Double.NaN, "key2", Double.POSITIVE_INFINITY, "key3", Double.NEGATIVE_INFINITY), "Message").isNotEqualTo(DataHelper.createHashMap("key1", Double.NaN, "key2", Double.POSITIVE_INFINITY, "key3", Double.NEGATIVE_INFINITY));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<{key1=NaN, key2=Infinity, key3=-Infinity}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toKeysTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toKeys().isNotEmpty();
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().toKeys().isNotEmpty();

        try {
            Raw.<String, String>mapAssertion().toKeys();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toKeys();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toKeys();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toKeys()).contains("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").toKeys()).contains("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toKeys().contains("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").toKeys().contains("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toKeysMatcherTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toKeys(Matchers.hasItems("key1", "key2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().toKeys(Matchers.hasItems("key1", "key2")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().toKeys(Matchers.hasItems(""));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toKeys(Matchers.hasItems(""));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toKeys(Matchers.hasItems(""));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toKeys(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toKeys(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).toKeys(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").toKeys(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toKeys(Matchers.hasItems("key"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\nExpected: (a collection containing \"key\")\n     but: a collection containing \"key\" mismatches were: [was \"key1\", was \"key2\"]");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").toKeys(Matchers.hasItems("key"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\nExpected: (a collection containing \"key\")\n     but: a collection containing \"key\" mismatches were: [was \"key1\", was \"key2\"]");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeyTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKey("key1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKey("key2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap(null, "value1", "key2", "value2")).containsKey(null);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2")).containsKey(null);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsKey("key1").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsKey("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKey("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKey("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKey("key3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsKey("key3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsKey("key3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsKey("key3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsKey("key3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsKey("key3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void doesNotContainKeyTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).doesNotContainKey("key3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).doesNotContainKey("key4");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2")).doesNotContainKey("key3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).doesNotContainKey(null);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().doesNotContainKey("key3").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().doesNotContainKey("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).doesNotContainKey("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").doesNotContainKey("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).doesNotContainKey("key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").doesNotContainKey("key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).doesNotContainKey("key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").doesNotContainKey("key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).doesNotContainKey("key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").doesNotContainKey("key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllKeysArrayTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key1", "key3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key2", "key3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key1", "key2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key2", "key1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeys(null, "key1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).isNotNull().containsAllKeys("key1", "key3").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAllKeys("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeys("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeys("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeys((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeys((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAllKeys((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAllKeys((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAllKeys();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAllKeys();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllKeys("key1", "key3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllKeys("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsAllKeys("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsAllKeys("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsAllKeys("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsAllKeys("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsAllKeys("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllKeysIterableTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(DataHelper.createIterable("key1", "key3"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(DataHelper.createIterable("key2", "key3"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(DataHelper.createIterable("key1", "key2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(DataHelper.createIterable("key2", "key1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeys(DataHelper.createIterable(null, "key1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).isNotNull().containsAllKeys(DataHelper.createIterable("key1", "key3")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAllKeys(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeys(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeys(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeys((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeys((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAllKeys((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAllKeys((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAllKeys(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAllKeys(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllKeys(DataHelper.createIterable("key1", "key3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllKeys(DataHelper.createIterable("key3", "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsAllKeys(DataHelper.createIterable("key3", "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllKeysInOrderArrayTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key1", "key2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key1", "key3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key2", "key3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key1", "key2", "key3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder("key1", null);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(null, "key3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).isNotNull().containsAllKeysInOrder("key1", "key2").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAllKeysInOrder("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeysInOrder("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeysInOrder("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeysInOrder((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeysInOrder((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAllKeysInOrder((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAllKeysInOrder((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAllKeysInOrder();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAllKeysInOrder();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllKeysInOrder("key1", "key3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key3", "key2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key2]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key2", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(null, "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[<NULL>, key1]> but was:<[key1, <NULL>, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllKeysInOrder("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsAllKeysInOrder("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsAllKeysInOrder("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsAllKeysInOrder("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsAllKeysInOrder("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsAllKeysInOrder("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllKeysInOrderIterableTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key1", "key2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key1", "key3"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key2", "key3"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key1", "key2", "key3"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key1", null));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable(null, "key3"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).isNotNull().containsAllKeysInOrder(DataHelper.createIterable("key1", "key2")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAllKeysInOrder(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeysInOrder(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeysInOrder(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeysInOrder((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeysInOrder((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAllKeysInOrder((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAllKeysInOrder((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAllKeysInOrder(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAllKeysInOrder(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllKeysInOrder(DataHelper.createIterable("key1", "key3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key3", "key2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key2]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key2", "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable(null, "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[<NULL>, key1]> but was:<[key1, <NULL>, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllKeysInOrder(DataHelper.createIterable("key3", "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsAllKeysInOrder(DataHelper.createIterable("key3", "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyArrayTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key1", "key2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key2", "key1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2")).containsKeysExactly(null, "key1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).containsKeysExactly();
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsKeysExactly("key1", "key2").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsKeysExactly("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactly("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactly("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactly((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactly((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsKeysExactly((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsKeysExactly((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key1", "key3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactly("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsKeysExactly("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsKeysExactly("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsKeysExactly("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsKeysExactly("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyIterableTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly(DataHelper.createIterable("key1", "key2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly(DataHelper.createIterable("key2", "key1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2")).containsKeysExactly(DataHelper.createIterable(null, "key1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).containsKeysExactly(DataHelper.<String>createIterable());
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsKeysExactly(DataHelper.createIterable("key1", "key2")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsKeysExactly(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactly(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactly(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactly((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactly((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsKeysExactly((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsKeysExactly((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly(DataHelper.createIterable("key1", "key3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly(DataHelper.createIterable("key3", "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactly(DataHelper.createIterable("key3", "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyInOrderArrayTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder("key1", "key2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2")).containsKeysExactlyInOrder("key1", null);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).containsKeysExactlyInOrder();
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsKeysExactlyInOrder("key1", "key2").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsKeysExactlyInOrder("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactlyInOrder("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactlyInOrder("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactlyInOrder((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactlyInOrder((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsKeysExactlyInOrder((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsKeysExactlyInOrder((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder("key1", "key3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsKeysExactlyInOrder("key3", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2")).containsKeysExactlyInOrder(null, "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[<NULL>, key1]> but was:<[key1, <NULL>]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsKeysExactlyInOrder("key1", null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, <NULL>]> but was:<[key1, <NULL>, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyInOrderIterableTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder(DataHelper.createIterable("key1", "key2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2")).containsKeysExactlyInOrder(DataHelper.createIterable("key1", null));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).containsKeysExactlyInOrder(DataHelper.<String>createIterable());
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsKeysExactlyInOrder(DataHelper.createIterable("key1", "key2")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsKeysExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactlyInOrder((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactlyInOrder((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsKeysExactlyInOrder((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsKeysExactlyInOrder((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder(DataHelper.createIterable("key1", "key3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsKeysExactlyInOrder(DataHelper.createIterable("key3", "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2")).containsKeysExactlyInOrder(DataHelper.createIterable(null, "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[<NULL>, key1]> but was:<[key1, <NULL>]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsKeysExactlyInOrder(DataHelper.createIterable("key1", null));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, <NULL>]> but was:<[key1, <NULL>, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder(DataHelper.createIterable("key2", "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactlyInOrder(DataHelper.createIterable("key2", "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAnyKeyArrayTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key1", "key2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key2", "key1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key1", "key3", "key5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key6", "key2", "key4");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2")).containsAnyKey("key6", null, "key4");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsAnyKey("key1", "key2").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAnyKey("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAnyKey("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAnyKey("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAnyKey((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAnyKey((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAnyKey((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAnyKey((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAnyKey();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAnyKey();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key4", "key6");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key4, key6]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key9", "key8", "key7");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsAnyKey("key9", "key8", "key7");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsAnyKey("key9", "key8", "key7");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsAnyKey("key9", "key8", "key7");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsAnyKey("key9", "key8", "key7");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsAnyKey("key9", "key8", "key7");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAnyKeyIterableTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(DataHelper.createIterable("key1", "key2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(DataHelper.createIterable("key2", "key1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(DataHelper.createIterable("key1", "key3", "key5"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(DataHelper.createIterable("key6", "key2", "key4"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2")).containsAnyKey(DataHelper.createIterable("key6", null, "key4"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsAnyKey(DataHelper.createIterable("key1", "key2")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAnyKey(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAnyKey(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAnyKey(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAnyKey((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAnyKey((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAnyKey((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAnyKey((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAnyKey(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAnyKey(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(DataHelper.createIterable("key4", "key6"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key4, key6]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(DataHelper.createIterable("key9", "key8", "key7"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsAnyKey(DataHelper.createIterable("key9", "key8", "key7"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNoKeyArrayTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key3", "key4");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key4", "key3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key6", "key7", "key8");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key7", "key6", "key8");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2")).containsNoKey("key7", "key6", "key8");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key7", null, "key8");
        initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsNoKey("key4", "key3");
        initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsNoKey("key4", "key3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsNoKey("key3", "key4").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsNoKey("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNoKey("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNoKey("key");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNoKey((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNoKey((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsNoKey((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsNoKey((String[]) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsNoKey();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsNoKey();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key2", "key4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key2, key4]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key3", "key2", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsNoKey("key3", "key2", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsNoKey("key3", "key2", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsNoKey("key3", "key2", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsNoKey("key3", "key2", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsNoKey("key3", "key2", "key1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNoKeyIterableTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key3", "key4"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key4", "key3"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key6", "key7", "key8"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key7", "key6", "key8"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", null, "value2")).containsNoKey(DataHelper.createIterable("key7", "key6", "key8"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key7", null, "key8"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsNoKey(DataHelper.createIterable("key3", "key4")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsNoKey(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNoKey(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNoKey(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNoKey((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNoKey((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsNoKey((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsNoKey((Iterable<String>) null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsNoKey(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsNoKey(DataHelper.<String>createIterable());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key2", "key4"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key2, key4]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key3", "key2", "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsNoKey(DataHelper.createIterable("key3", "key2", "key1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toValuesTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toValues().isNotEmpty();
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", null)).toValues().contains("value1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", null)).toValues().contains(null);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().toValues().isNotEmpty();

        try {
            Raw.<String, String>mapAssertion().toValues();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toValues();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toValues();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toValues()).contains("value");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's values.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").toValues()).contains("value");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's values.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toValues().contains("value");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's values.\n\tActual value should contain the expected value.\n\tExpected:<value> but was:<[value1, value2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").toValues().contains("value");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's values.\n\tActual value should contain the expected value.\n\tExpected:<value> but was:<[value1, value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toValuesMatcherTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toValues(Matchers.hasItems("value1", "value2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", null)).toValues(Matchers.hasItems("value1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", null)).toValues(Matchers.hasItems((String) null));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().toValues(Matchers.hasItems("value1", "value2")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().toValues(Matchers.hasItems(""));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toValues(Matchers.hasItems(""));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toValues(Matchers.hasItems(""));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toValues(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toValues(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).toValues(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").toValues(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toValues(Matchers.hasItems("value"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's values.\nExpected: (a collection containing \"value\")\n     but: a collection containing \"value\" mismatches were: [was \"value1\", was \"value2\"]");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").toValues(Matchers.hasItems("value"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's values.\nExpected: (a collection containing \"value\")\n     but: a collection containing \"value\" mismatches were: [was \"value1\", was \"value2\"]");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsEntryTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsEntry("key1", "value1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsEntry("key2", "value2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap(null, "value1", "key2", "value2")).containsEntry(null, "value1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", null, "key2", "value2")).containsEntry("key1", null);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsEntry("key1", "value1").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsEntry("key", "value");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsEntry("key", "value");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsEntry("key", "value");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsEntry(null, "value");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{<NULL>=value}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsEntry("key", null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key=<NULL>}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsEntry("key1", "value2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsEntry("key2", "value1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key2=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsEntry("key3", "value3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsEntry("key3", "value3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsEntry("key3", "value3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsEntry("key3", "value3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsEntry("key3", "value3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsEntry("key3", "value3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void doesNotContainEntryTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key", "value");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key1", "value2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key2", "value1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry(null, "value");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key", null);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap(null, "value1", "key2", "value2")).doesNotContainEntry("key1", "value1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", null, "key2", "value2")).doesNotContainEntry("key1", "value1");
        initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).doesNotContainEntry("key1", "value2");
        initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).doesNotContainEntry("key1", "value2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().doesNotContainEntry("key", "value").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().doesNotContainEntry("key", "value");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).doesNotContainEntry("key", "value");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").doesNotContainEntry("key", "value");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key1", "value1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key2", "value2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").doesNotContainEntry("key2", "value2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).doesNotContainEntry("key1", "value1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").doesNotContainEntry("key1", "value1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).doesNotContainEntry("key1", "value1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").doesNotContainEntry("key1", "value1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=1(49)}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAll1Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAll("k1", "v1").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAll("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAll("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAll("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAll2Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1", "k2", "v2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAll("k1", "v1", "k2", "v2").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAll("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAll("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAll("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAll3Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1", "k2", "v2", "k3", "v3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3", "k5", "v5", "k2", "v2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAll("k1", "v1", "k2", "v2", "k3", "v3").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAll("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAll("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAll("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAll4Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3", "k5", "v5", "k2", "v2", "k1", "v1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1", "k2", "v2", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1, k2=v2, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1", "k2", "v2", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1, k2=v2, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAll5Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3", "k5", "v5", "k2", "v2", "k1", "v1", "k4", "v4");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1", "k1", "v1", "k2", "v2", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1, k1=v1, k2=v2, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1", "k1", "v1", "k2", "v2", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1, k1=v1, k2=v2, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key1", "value1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key2", "value2", "key1", "value1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap(null, "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key2", "value2", null, "value1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap(null, "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key2", "value2", null, "value1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", null, "key2", "value2")).containsAll(DataHelper.createHashMap("key2", "value2", "key1", null));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", null, "key2", "value2")).containsAll(DataHelper.createHashMap("key2", "value2", "key1", null));
        initialize(Raw.<String, String>mapAssertion(), createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3")).containsAll(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsAll(DataHelper.createHashMap("key1", "value1")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAll(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAll(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAll(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAll(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAll(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAll(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAll(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "", (Object) "")).containsAll(DataHelper.createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "", (Object) ""), "Message").containsAll(DataHelper.createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key1", "value2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsAll(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsAll(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsAll(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsAll(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsAll(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key1", "value2", "key1", "value3")).containsAll(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key1", "value2", "key1", "value3"), "Message").containsAll(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllInOrder1Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k3", "v3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAllInOrder("k1", "v1").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAllInOrder("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllInOrder("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllInOrder("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k5", "v5", "k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k5=v5, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k5", "v5", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k5=v5, k2=v2}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllInOrder2Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k2", "v2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k3", "v3", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAllInOrder("k1", "v1", "k2", "v2").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAllInOrder("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllInOrder("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllInOrder("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v2", "k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v2", "k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllInOrder3Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k3", "v3", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllInOrder4Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllInOrder5Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key1", "value1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap(null, "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap(null, "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", null, "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key1", null, "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3")).containsAllInOrder(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsAllInOrder(DataHelper.createHashMap("key1", "value1")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAllInOrder(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllInOrder(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllInOrder(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllInOrder(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllInOrder(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAllInOrder(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAllInOrder(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "", (Object) "")).containsAllInOrder(DataHelper.createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "", (Object) ""), "Message").containsAllInOrder(DataHelper.createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key1", "value2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key2", "value2", "key1", "value1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key2=value2, key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap(null, "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key2", "value2", null, "value1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key2=value2, <NULL>=value1}> but was:<{<NULL>=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", null, "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key2", "value2", "key1", null));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key2=value2, key1=<NULL>}> but was:<{key1=<NULL>, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsAllInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsAllInOrder(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsAllInOrder(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsAllInOrder(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsAllInOrder(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key1", "value2", "key1", "value3")).containsAllInOrder(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key1", "value2", "key1", "value3"), "Message").containsAllInOrder(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactly0Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).containsExactly();
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isNotNull().containsExactly().isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactly();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactly();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactly();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactly1Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1")).containsExactly("k1", "v1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1")).isNotNull().containsExactly("k1", "v1").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactly("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactly("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactly("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactly2Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2")).containsExactly("k1", "v1", "k2", "v2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2")).containsExactly("k2", "v2", "k1", "v1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2")).isNotNull().containsExactly("k1", "v1", "k2", "v2").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactly("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactly("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactly("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6", "k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6", "k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactly3Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3")).containsExactly("k1", "v1", "k2", "v2", "k3", "v3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3")).containsExactly("k2", "v2", "k1", "v1", "k3", "v3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3")).isNotNull().containsExactly("k1", "v1", "k2", "v2", "k3", "v3").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactly("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactly("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactly("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6", "k1", "v1", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6", "k1", "v1", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactly4Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4")).containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4")).containsExactly("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4")).isNotNull().containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactly5Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key2", "value2", "key1", "value1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap(null, "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap(null, "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", null, "key2", "value2")).containsExactly(DataHelper.createHashMap("key1", null, "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).containsExactly(DataHelper.<String, String>createHashMap());
        initialize(Raw.<String, String>mapAssertion(), createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3")).containsExactly(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsExactly(DataHelper.createHashMap("key1", "value1", "key2", "value2")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactly(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactly(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactly(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactly(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactly(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsExactly(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsExactly(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key1", "value1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key2", "value2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key1", "value2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key1", "value2", "key2", "value1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value2, key2=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsExactly(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsExactly(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsExactly(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsExactly(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsExactly(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key1", "value2", "key1", "value3")).containsExactly(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key1", "value2", "key1", "value3"), "Message").containsExactly(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder0Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).containsExactlyInOrder();
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isNotNull().containsExactlyInOrder().isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactlyInOrder();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactlyInOrder();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactlyInOrder();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder1Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1")).containsExactlyInOrder("k1", "v1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1")).isNotNull().containsExactlyInOrder("k1", "v1").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactlyInOrder("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactlyInOrder("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder2Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2")).containsExactlyInOrder("k1", "v1", "k2", "v2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2")).isNotNull().containsExactlyInOrder("k1", "v1", "k2", "v2").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactlyInOrder("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactlyInOrder("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2", "k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2", "k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder3Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3")).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3")).isNotNull().containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder4Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4")).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4")).isNotNull().containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder5Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap(null, "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap(null, "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", null, "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key1", null, "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).containsExactlyInOrder(DataHelper.<String, String>createHashMap());
        initialize(Raw.<String, String>mapAssertion(), createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3")).containsExactlyInOrder(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsExactlyInOrder(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactlyInOrder(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactlyInOrder(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactlyInOrder(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsExactlyInOrder(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsExactlyInOrder(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key1", "value2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key1", "value1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key1", "value2", "key2", "value1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value2, key2=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap(null, "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", null, "value1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, <NULL>=value1}> but was:<{<NULL>=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", null, "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key1", null));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key1=<NULL>}> but was:<{key1=<NULL>, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsExactlyInOrder(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsExactlyInOrder(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsExactlyInOrder(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsExactlyInOrder(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key1", "value2", "key1", "value3")).containsExactlyInOrder(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key1", "value2", "key1", "value3"), "Message").containsExactlyInOrder(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAny1Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAny("k1", "v1").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAny("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAny("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAny("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAny2Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1", "k2", "v2");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k7", "v7", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAny("k1", "v1", "k2", "v2").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAny("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAny("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAny("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11", "k2", "v22");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11", "k2", "v22");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAny3Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1", "k2", "v2", "k3", "v3");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k7", "v7", "k8", "v8", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAny("k1", "v1", "k2", "v2", "k3", "v3").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAny("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAny("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAny("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAny4Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k7", "v7", "k8", "v8", "k9", "v9", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33, k4=v44}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33, k4=v44}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAny5Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k7", "v7", "k8", "v8", "k9", "v9", "k10", "v10", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33, k4=v44, k5=v55}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33, k4=v44, k5=v55}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAny(DataHelper.createHashMap("key1", "value1", "key3", "value3", "key5", "value5"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAny(DataHelper.createHashMap("key4", "value4", "key2", "value2", "key1", "value1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap(null, "value1", "key2", "value2")).containsAny(DataHelper.createHashMap(null, "value1", "key3", "value3", "key5", "value5"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", null, "key2", "value2")).containsAny(DataHelper.createHashMap("key1", null, "key3", "value3", "key5", "value5"));
        initialize(Raw.<String, String>mapAssertion(), createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3")).containsAny(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key1", "value2", "key1", "value3")).containsAny(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsAny(DataHelper.createHashMap("key1", "value1", "key3", "value3", "key5", "value5")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsAny(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAny(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAny(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAny(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAny(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsAny(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsAny(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "", (Object) "")).containsAny(DataHelper.createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "", (Object) ""), "Message").containsAny(DataHelper.createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAny(DataHelper.createHashMap("key1", "value"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key1=value}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAny(DataHelper.createHashMap("key", "value1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAny(DataHelper.createHashMap("key", (String) null));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key=<NULL>}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsAny(DataHelper.createHashMap("key", "value"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsAny(DataHelper.createHashMap("key", "value"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsAny(DataHelper.createHashMap((Object) "key", (Object) "value"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsAny(DataHelper.createHashMap((Object) "key", (Object) "value"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsAny(DataHelper.createHashMap((Object) "key", (Object) "value"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsAny(DataHelper.createHashMap((Object) "key", (Object) "value"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, key2=1(49)}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNone1Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsNone("k1", "v11").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsNone("k1", "v11");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNone("k1", "v11");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNone("k1", "v11");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNone2Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11", "k2", "v22");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsNone("k1", "v11", "k2", "v22").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsNone("k1", "v11", "k2", "v22");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNone("k1", "v11", "k2", "v22");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNone("k1", "v11", "k2", "v22");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1", "k2", "v2");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNone3Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11", "k2", "v22", "k3", "v33");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsNone("k1", "v11", "k2", "v22", "k3", "v33").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsNone("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNone("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNone("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNone4Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNone5Test() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).isNotNull().containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55").isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNone(DataHelper.createHashMap("key3", "value3", "key4", "value4", "key5", "value5"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNone(DataHelper.createHashMap("key", "value"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap(null, "value1", "key2", "value2")).containsNone(DataHelper.createHashMap("key1", "value1"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", null, "key2", "value2")).containsNone(DataHelper.createHashMap("key1", "value1"));
        initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2")).containsNone(DataHelper.createHashMap(null, (Object) "value1"));
        initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2")).containsNone(DataHelper.createHashMap((Object) "key1", null));
        initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsNone(DataHelper.createHashMap((Object) "key", (Object) "value"));
        initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsNone(DataHelper.createHashMap((Object) "key", (Object) "value"));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).isNotNull().containsNone(DataHelper.createHashMap("key3", "value3", "key4", "value4", "key5", "value5")).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().containsNone(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNone(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNone(DataHelper.<String, String>createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNone(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNone(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).containsNone(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").containsNone(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "", (Object) "")).containsNone(DataHelper.createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "", (Object) ""), "Message").containsNone(DataHelper.createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNone(DataHelper.createHashMap("key1", "value1"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsNone(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").containsNone(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsNone(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsNone(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsNone(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsNone(DataHelper.createHashMap((Object) "key1", (Object) "value1", "key2", "value2"));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, key2=1(49)}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).toSize().isEqualTo(0);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1")).toSize().isEqualTo(1);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toSize().isEqualTo(2);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).toSize().isEqualTo(3);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1")).isNotNull().toSize().isEqualTo(1);

        try {
            Raw.<String, String>mapAssertion().toSize();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toSize();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toSize();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toSize()).isEqualTo(1);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").toSize()).isEqualTo(1);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toSize().isEqualTo(3);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").toSize().isEqualTo(3);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toSizeMatcherTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).toSize(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1")).toSize(Matchers.equalTo(1));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toSize(Matchers.equalTo(2));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).toSize(Matchers.equalTo(3));
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1")).isNotNull().toSize(Matchers.equalTo(1)).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().toSize(Matchers.equalTo(0));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toSize(Matchers.equalTo(0));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toSize(Matchers.equalTo(0));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toSize(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toSize(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", "")).toSize(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("", ""), "Message").toSize(null);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).toSize(Matchers.equalTo(3));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\nExpected: <3>\n     but: was <2>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").toSize(Matchers.equalTo(3));
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\nExpected: <3>\n     but: was <2>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).hasSize(0);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1")).hasSize(1);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).hasSize(2);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).hasSize(3);
        initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1")).isNotNull().hasSize(1).isInstanceOf(Map.class);

        try {
            Raw.<String, String>mapAssertion().hasSize(1);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).hasSize(1);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").hasSize(1);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2")).hasSize(3);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.createHashMap("key1", "value1", "key2", "value2"), "Message").hasSize(3);
            Assertions.fail(MapAssertion.class);
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
            initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap()).isNull();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), DataHelper.<String, String>createHashMap(), "Message").isNull();
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<<EMPTY>>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Map<Object, Object> value = DataHelper.createHashMap();
        initialize(Raw.mapAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.mapAssertion(), value).isSameAs(DataHelper.createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<<EMPTY>> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.mapAssertion(), value, "Message").isSameAs(DataHelper.createHashMap());
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<<EMPTY>> but was:<<EMPTY>>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Map<Object, Object> value = DataHelper.createHashMap();
        initialize(Raw.mapAssertion(), value).isNotSameAs(DataHelper.createHashMap());

        try {
            initialize(Raw.mapAssertion(), value).isNotSameAs(value);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.mapAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(MapAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<<EMPTY>>");
        }
    }

}
