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
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link CollectionAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CollectionAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CollectionAssertionTest() {
        super();
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.<String>collectionAssertion(), new ArrayList<String>()).isEmpty();
        initialize(Raw.<String>collectionAssertion(), new HashSet<String>()).isEmpty();

        try {
            initialize(Raw.<String>collectionAssertion(), null).isEmpty();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null, "Message").isEmpty();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).isEmpty();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2"), "Message").isEmpty();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.<String>collectionAssertion(), new ArrayList<String>()).isNullOrEmpty();
        initialize(Raw.<String>collectionAssertion(), new HashSet<String>()).isNullOrEmpty();
        initialize(Raw.<String>collectionAssertion(), null).isNullOrEmpty();

        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).isNullOrEmpty();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).isNotEmpty();
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("test1", "test2")).isNotEmpty();

        try {
            initialize(Raw.<String>collectionAssertion(), null).isNotEmpty();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), new ArrayList<String>()).isNotEmpty();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), new ArrayList<String>(), "Message").isNotEmpty();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), new HashSet<String>()).isNotEmpty();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), new HashSet<String>(), "Message").isNotEmpty();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).contains("val1");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).contains("val2");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList(null, "val1", "val2")).contains(null);
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", null, "val2")).contains(null);
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", null)).contains(null);

        try {
            initialize(Raw.<String>collectionAssertion(), null).contains("val");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null, "Message").contains("val");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).contains("val3");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2"), "Message").contains("val3");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).doesNotContain("val3");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", null)).doesNotContain("val3");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).doesNotContain(null);

        try {
            initialize(Raw.<String>collectionAssertion(), null).doesNotContain("val");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null, "Message").doesNotContain("val");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).doesNotContain("val1");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).doesNotContain("val2");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2"), "Message").doesNotContain("val2");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", null, "val2")).doesNotContain(null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<null> but was:<[val1, null, val2]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", null, "val2"), "Message").doesNotContain(null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<null> but was:<[val1, null, val2]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val3");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val5", "val1", "val3");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val5", "val4");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1", "val4", "val5", "val2");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val3", "val1", "val4", "val5", "val2"));
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAll("val3", "val1", "val4", null, "val2");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAll(Arrays.asList("val3", "val1", "val4", null, "val2"));

        try {
            initialize(Raw.<String>collectionAssertion(), null).containsAll("val");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsAll(new ArrayList<String>());
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsAll((String[]) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsAll((Iterable<String>) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsAll((String[]) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsAll((Iterable<String>) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsAll();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsAll(new ArrayList<String>());
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val6");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val0", "val1");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val1", "val2");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3", "val5");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val4", "val5");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val1", "val1", "val2", "val2")).containsAllInOrder("val1", "val1", "val1", "val2", "val2");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAllInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));

        try {
            initialize(Raw.<String>collectionAssertion(), null).containsAllInOrder("val");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsAllInOrder((String[]) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsAllInOrder((String[]) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsAllInOrder();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val6");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val1");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val1", "val1")).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val1", "val2", "val3");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val2", "val1", "val3");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val2", "val3", "val1");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val3", "val2", "val1");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsExactly("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsExactly("val2", "val4", "val1", "val3", "val5");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", "val5"));
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsExactly("val2", "val4", "val1", "val3", null);
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", null));
        initialize(Raw.<String>collectionAssertion(), new ArrayList<String>()).containsExactly();
        initialize(Raw.<String>collectionAssertion(), new ArrayList<String>()).containsExactly(new ArrayList<String>());

        try {
            initialize(Raw.<String>collectionAssertion(), null).containsExactly("val");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsExactly(new ArrayList<String>());
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsExactly((String[]) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsExactly((Iterable<String>) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsExactly((String[]) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsExactly((Iterable<String>) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val1", "val2");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val2", "val1");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly(new ArrayList<String>());
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val2", "val4", "val1");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsExactlyInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));
        initialize(Raw.<String>collectionAssertion(), new ArrayList<String>()).containsExactlyInOrder();
        initialize(Raw.<String>collectionAssertion(), new ArrayList<String>()).containsExactlyInOrder(new ArrayList<String>());

        try {
            initialize(Raw.<String>collectionAssertion(), null).containsExactlyInOrder("val");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsExactlyInOrder((String[]) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsExactlyInOrder((String[]) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder("val2", "val3");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsAny("val1", "val3", "val5");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsAny("val6", "val2", "val4");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAny("val7", "val9", "val1", "val5", "val3");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAny(Arrays.asList("val7", "val9", "val1", "val5", "val3"));
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAny("val7", "val9", "val1", null, "val3");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAny(Arrays.asList("val7", "val9", "val1", null, "val3"));
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAny("val7", "val9", null);
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAny(Arrays.asList("val7", "val9", null));

        try {
            initialize(Raw.<String>collectionAssertion(), null).containsAny("val");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsAny(new ArrayList<String>());
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsAny((String[]) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsAny((Iterable<String>) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsAny((String[]) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsAny((Iterable<String>) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsAny();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsAny(new ArrayList<String>());
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsAny("val4", "val5", "val6");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAny("val8", "val7");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny("val8", "val7");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone("val4", "val5", "val6");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone("val8", "val4");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone(Arrays.asList("val8", "val4"));
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", null)).containsNone("val8", "val4");
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", null)).containsNone(Arrays.asList("val8", "val4"));
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone("val8", "val4", null);
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone(Arrays.asList("val8", "val4", null));

        try {
            initialize(Raw.<String>collectionAssertion(), null).containsNone("val");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsNone(new ArrayList<String>());
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsNone((String[]) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null).containsNone((Iterable<String>) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsNone((String[]) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsNone((Iterable<String>) null);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsNone();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2")).containsNone(new ArrayList<String>());
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone("val2");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone("val4", "val2");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).toSize().isEqualTo(3);
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).toSize().isGreaterThan(2);
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).toSize().isLessThan(6);

        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).toSize().isEqualTo(5);
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).toSize().isGreaterThan(1);
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).toSize().isLessThan(9);

        try {
            initialize(Raw.<String>collectionAssertion(), null).toSize();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), null, "Message").toSize();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).toSize().isEqualTo(4);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").toSize().isEqualTo(4);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).hasSize(3);
        initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).hasSize(5);

        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).hasSize(4);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").hasSize(4);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.<String>collectionAssertion(), null).isNull();

        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3")).isNull();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").isNull();
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Collection<String> value = Arrays.asList("val1", "val2", "val3");
        initialize(Raw.<String>collectionAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.<String>collectionAssertion(), value).isSameAs(Arrays.asList("val1", "val2", "val3"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[val1, val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), value, "Message").isSameAs(Arrays.asList("val1", "val2", "val3"));
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[val1, val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), value).isSameAs("test");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Collection<String> value = Arrays.asList("val1", "val2", "val3");
        initialize(Raw.<String>collectionAssertion(), value).isNotSameAs(Arrays.asList("val1", "val2", "val3"));
        initialize(Raw.<String>collectionAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.<String>collectionAssertion(), value).isNotSameAs(value);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>collectionAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("CollectionAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.<String>collectionAssertion(), null).asString(null));
            Assertions.fail("CollectionAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.<String>collectionAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.<String>collectionAssertion(), null).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(initialize(Raw.<String>collectionAssertion(), null).asString(Arrays.asList("val1", "val2", "val3", "val4", "val5"))).isEqualTo("[val1, val2, val3, val4, val5]");
    }

}
