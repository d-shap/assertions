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
package ru.d_shap.assertions.array;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

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
        new BooleanArrayAssertion(new boolean[]{true, false}, new FailDescription()).contains(true);
        new BooleanArrayAssertion(new boolean[]{true, false}, new FailDescription()).contains(false);

        try {
            new BooleanArrayAssertion(null, new FailDescription()).contains(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).contains(false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<false> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription("Message")).contains(false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<false> but was:<[true, true]>.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).doesNotContain(false);

        try {
            new BooleanArrayAssertion(null, new FailDescription()).doesNotContain(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).doesNotContain(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<true> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription("Message")).doesNotContain(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<true> but was:<[true, true]>.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAll(true, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsAll(true, false);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsAll(false, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsAll(Arrays.asList(Boolean.FALSE, Boolean.TRUE));

        try {
            new BooleanArrayAssertion(null, new FailDescription()).containsAll(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(null, new FailDescription()).containsAll(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAll((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAll();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAll((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAll(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAll(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[false, false]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription("Message")).containsAll(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[false, false]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAll(Arrays.asList(Boolean.FALSE, Boolean.FALSE));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[false, false]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription("Message")).containsAll(Arrays.asList(Boolean.FALSE, Boolean.FALSE));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[false, false]> but was:<[true, true]>.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAllInOrder(true, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsAllInOrder(true, false);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsAllInOrder(Arrays.asList(Boolean.TRUE, Boolean.FALSE));

        try {
            new BooleanArrayAssertion(null, new FailDescription()).containsAllInOrder(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAllInOrder((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAllInOrder();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAllInOrder((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAllInOrder(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAllInOrder(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[false, false]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, false}, new FailDescription()).containsAllInOrder(false, true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[false, true]> but was:<[true, false]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, false}, new FailDescription("Message")).containsAllInOrder(false, true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[false, true]> but was:<[true, false]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, false}, new FailDescription()).containsAllInOrder(Arrays.asList(Boolean.FALSE, Boolean.TRUE));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[false, true]> but was:<[true, false]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, false}, new FailDescription("Message")).containsAllInOrder(Arrays.asList(Boolean.FALSE, Boolean.TRUE));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[false, true]> but was:<[true, false]>.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsExactly(true, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsExactly(true, false, true, false);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsExactly(false, false, true, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsExactly(Arrays.asList(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
        new BooleanArrayAssertion(new boolean[0], new FailDescription()).containsExactly();
        new BooleanArrayAssertion(new boolean[0], new FailDescription()).containsExactly(new ArrayList<Boolean>());

        try {
            new BooleanArrayAssertion(null, new FailDescription()).containsExactly(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(null, new FailDescription()).containsExactly(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsExactly((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsExactly((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsExactly(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[false, false]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsExactly(true, true, false, false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[true, true, false, false, false]> but was:<[true, true, false, false]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsExactly();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsExactly(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsExactly(true, true, true, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[true, true, true, false]> but was:<[true, true, false, false]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription("Message")).containsExactly(true, true, true, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[true, true, true, false]> but was:<[true, true, false, false]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsExactly(Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[true, true, true, false]> but was:<[true, true, false, false]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription("Message")).containsExactly(Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[true, true, true, false]> but was:<[true, true, false, false]>.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsExactlyInOrder(true, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsExactlyInOrder(true, true, false, false);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsExactlyInOrder(Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
        new BooleanArrayAssertion(new boolean[0], new FailDescription()).containsExactlyInOrder();
        new BooleanArrayAssertion(new boolean[0], new FailDescription()).containsExactlyInOrder(new ArrayList<Boolean>());

        try {
            new BooleanArrayAssertion(null, new FailDescription()).containsExactlyInOrder(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsExactlyInOrder((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsExactlyInOrder((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsExactlyInOrder(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[false, false]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsExactlyInOrder(true, true, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false]> but was:<[true, true, false, false]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsExactlyInOrder(true, true, false, false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false, false, false]> but was:<[true, true, false, false]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsExactlyInOrder();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsExactlyInOrder(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsExactlyInOrder(true, false, true, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[true, false, true, false]> but was:<[true, true, false, false]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription("Message")).containsExactlyInOrder(true, false, true, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[true, false, true, false]> but was:<[true, true, false, false]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsExactlyInOrder(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[true, false, true, false]> but was:<[true, true, false, false]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription("Message")).containsExactlyInOrder(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[true, false, true, false]> but was:<[true, true, false, false]>.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAny(true, true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsAny(true);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsAny(false);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsAny(true, false);
        new BooleanArrayAssertion(new boolean[]{true, true, false, false}, new FailDescription()).containsAny(Arrays.asList(Boolean.TRUE, Boolean.FALSE));

        try {
            new BooleanArrayAssertion(null, new FailDescription()).containsAny(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(null, new FailDescription()).containsAny(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAny((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAny();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAny((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAny(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAny(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[false, false]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription("Message")).containsAny(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[false, false]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsAny(Arrays.asList(Boolean.FALSE, Boolean.FALSE));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[false, false]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription("Message")).containsAny(Arrays.asList(Boolean.FALSE, Boolean.FALSE));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[false, false]> but was:<[true, true]>.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsNone(false);
        new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsNone(false, false);
        new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsNone(Arrays.asList(Boolean.FALSE, Boolean.FALSE));

        try {
            new BooleanArrayAssertion(null, new FailDescription()).containsNone(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(null, new FailDescription()).containsNone(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsNone((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsNone();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsNone((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsNone(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsNone(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[true]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsNone(false, true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[false, true]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription("Message")).containsNone(false, true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[false, true]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).containsNone(Arrays.asList(Boolean.FALSE, Boolean.TRUE));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[false, true]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription("Message")).containsNone(Arrays.asList(Boolean.FALSE, Boolean.TRUE));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[false, true]> but was:<[true, true]>.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new BooleanArrayAssertion(null, new FailDescription()).isNull();

        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription()).isNull();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, true}, new FailDescription("Message")).isNull();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[true, true]>.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        boolean[] value = new boolean[]{true, true};
        new BooleanArrayAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new BooleanArrayAssertion(value, new FailDescription()).isSameAs(new boolean[]{true, true});
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[true, true]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(value, new FailDescription("Message")).isSameAs(new boolean[]{true, true});
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[true, true]> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[true, true]>.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        boolean[] value = new boolean[]{true, true};
        new BooleanArrayAssertion(value, new FailDescription()).isNotSameAs(new boolean[]{true, true});
        new BooleanArrayAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new BooleanArrayAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[true, true]>.");
        }
        try {
            new BooleanArrayAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[true, true]>.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new BooleanArrayAssertion(null, new FailDescription()).asString(null, true)).isNull();
        Assertions.assertThat(new BooleanArrayAssertion(null, new FailDescription()).asString(new StringBuilder("test"), true)).isEqualTo("test");
        Assertions.assertThat(new BooleanArrayAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3"), true)).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new BooleanArrayAssertion(null, new FailDescription()).asString(new boolean[]{true, true}, true)).isEqualTo("[true, true]");

        Assertions.assertThat(new BooleanArrayAssertion(null, new FailDescription()).asString(null, false)).isNull();
        Assertions.assertThat(new BooleanArrayAssertion(null, new FailDescription()).asString(new StringBuilder("test"), false)).isEqualTo("test");
        Assertions.assertThat(new BooleanArrayAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3"), false)).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new BooleanArrayAssertion(null, new FailDescription()).asString(new boolean[]{true, true}, false)).isEqualTo("[true, true]");
    }

}
