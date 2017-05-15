///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
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
package ru.d_shap.assertions.array;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link BooleanArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class BooleanArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public BooleanArrayAssertionTest() {
        super();
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        new BooleanArrayAssertion(new boolean[]{true, false}, null).contains(true);
        new BooleanArrayAssertion(new boolean[]{true, false}, null).contains(false);

        try {
            new BooleanArrayAssertion(null, null).contains(true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).contains(false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<false> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, "Message").contains(false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<false> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, null).doesNotContain(false);

        try {
            new BooleanArrayAssertion(null, null).doesNotContain(true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).doesNotContain(true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<true> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, "Message").doesNotContain(true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<true> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAll(true, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsAll(true, false);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsAll(false, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsAll(Arrays.asList(Boolean.FALSE, Boolean.TRUE));

        try {
            new BooleanArrayAssertion(null, null).containsAll(true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(null, null).containsAll(new ArrayList<Boolean>());
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAll((boolean[]) null);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAll();
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAll((Iterable<Boolean>) null);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAll(new ArrayList<Boolean>());
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAll(false, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, "Message").containsAll(false, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAll(Arrays.asList(Boolean.FALSE, Boolean.FALSE));
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, "Message").containsAll(Arrays.asList(Boolean.FALSE, Boolean.FALSE));
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAllInOrder(true, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsAllInOrder(true, false);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsAllInOrder(Arrays.asList(Boolean.TRUE, Boolean.FALSE));

        try {
            new BooleanArrayAssertion(null, null).containsAllInOrder(true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(null, null).containsAllInOrder(new ArrayList<Boolean>());
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAllInOrder((boolean[]) null);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAllInOrder();
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAllInOrder((Iterable<Boolean>) null);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAllInOrder(new ArrayList<Boolean>());
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAllInOrder(false, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, false}, null).containsAllInOrder(false, true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[false, true]> but was:<[true, false]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, false}, "Message").containsAllInOrder(false, true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[false, true]> but was:<[true, false]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, false}, null).containsAllInOrder(Arrays.asList(Boolean.FALSE, Boolean.TRUE));
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[false, true]> but was:<[true, false]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, false}, "Message").containsAllInOrder(Arrays.asList(Boolean.FALSE, Boolean.TRUE));
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[false, true]> but was:<[true, false]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, null).containsExactly(true, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsExactly(true, false, true, false);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsExactly(false, false, true, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsExactly(Arrays.asList(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
        new BooleanArrayAssertion(new boolean[0], null).containsExactly();
        new BooleanArrayAssertion(new boolean[0], null).containsExactly(new ArrayList<Boolean>());

        try {
            new BooleanArrayAssertion(null, null).containsExactly(true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(null, null).containsExactly(new ArrayList<Boolean>());
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsExactly((boolean[]) null);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsExactly((Iterable<Boolean>) null);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsExactly(false, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsExactly(true, true, false, false, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[true, true, false, false, false]> but was:<[true, true, false, false]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsExactly();
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsExactly(new ArrayList<Boolean>());
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsExactly(true, true, true, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[true, true, true, false]> but was:<[true, true, false, false]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, "Message").containsExactly(true, true, true, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[true, true, true, false]> but was:<[true, true, false, false]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsExactly(Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE));
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[true, true, true, false]> but was:<[true, true, false, false]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, "Message").containsExactly(Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE));
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[true, true, true, false]> but was:<[true, true, false, false]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, null).containsExactlyInOrder(true, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsExactlyInOrder(true, true, false, false);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsExactlyInOrder(Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
        new BooleanArrayAssertion(new boolean[0], null).containsExactlyInOrder();
        new BooleanArrayAssertion(new boolean[0], null).containsExactlyInOrder(new ArrayList<Boolean>());

        try {
            new BooleanArrayAssertion(null, null).containsExactlyInOrder(true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(null, null).containsExactlyInOrder(new ArrayList<Boolean>());
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsExactlyInOrder((boolean[]) null);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsExactlyInOrder((Iterable<Boolean>) null);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsExactlyInOrder(false, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsExactlyInOrder(true, true, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false]> but was:<[true, true, false, false]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsExactlyInOrder(true, true, false, false, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false, false, false]> but was:<[true, true, false, false]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsExactlyInOrder();
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsExactlyInOrder(new ArrayList<Boolean>());
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsExactlyInOrder(true, false, true, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[true, false, true, false]> but was:<[true, true, false, false]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, "Message").containsExactlyInOrder(true, false, true, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[true, false, true, false]> but was:<[true, true, false, false]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsExactlyInOrder(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[true, false, true, false]> but was:<[true, true, false, false]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, "Message").containsExactlyInOrder(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[true, false, true, false]> but was:<[true, true, false, false]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAny(true, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsAny(true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsAny(false);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsAny(true, false);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, null).containsAny(Arrays.asList(Boolean.TRUE, Boolean.FALSE));

        try {
            new BooleanArrayAssertion(null, null).containsAny(true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(null, null).containsAny(new ArrayList<Boolean>());
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAny((boolean[]) null);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAny();
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAny((Iterable<Boolean>) null);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAny(new ArrayList<Boolean>());
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAny(false, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, "Message").containsAny(false, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsAny(Arrays.asList(Boolean.FALSE, Boolean.FALSE));
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, "Message").containsAny(Arrays.asList(Boolean.FALSE, Boolean.FALSE));
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, null).containsNone(false);
        new BooleanArrayAssertion(new boolean[]{true, true}, null).containsNone(false, false);
        new BooleanArrayAssertion(new boolean[]{true, true}, null).containsNone(Arrays.asList(Boolean.FALSE, Boolean.FALSE));

        try {
            new BooleanArrayAssertion(null, null).containsNone(true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(null, null).containsNone(new ArrayList<Boolean>());
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsNone((boolean[]) null);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsNone();
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsNone((Iterable<Boolean>) null);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsNone(new ArrayList<Boolean>());
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsNone(true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[true]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsNone(false, true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[false, true]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, "Message").containsNone(false, true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[false, true]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).containsNone(Arrays.asList(Boolean.FALSE, Boolean.TRUE));
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[false, true]> but was:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, "Message").containsNone(Arrays.asList(Boolean.FALSE, Boolean.TRUE));
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[false, true]> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new BooleanArrayAssertion(new boolean[0], null).createCollectionAssertion().isEmpty();
        new BooleanArrayAssertion(new boolean[]{true, true}, null).createCollectionAssertion().isNotEmpty();

        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, null).createCollectionAssertion().isEmpty();
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, "Message").createCollectionAssertion().isEmpty();
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[true, true]>");
        }
    }

}
