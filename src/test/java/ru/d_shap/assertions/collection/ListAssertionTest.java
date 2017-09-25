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
import java.util.LinkedList;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link ListAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ListAssertionTest {

    /**
     * Test class constructor.
     */
    public ListAssertionTest() {
        super();
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isRandomAccessTest() {
        new ListAssertion(new ArrayList<String>(), new FailDescription()).isRandomAccess();

        try {
            new ListAssertion(null, new FailDescription()).isRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ListAssertion(new LinkedList<String>(), new FailDescription()).isRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should be the subtype of the expected value. Expected:<java.util.RandomAccess> but was:<java.util.LinkedList>.");
        }
        try {
            new ListAssertion(new LinkedList<String>(), new FailDescription().addMessage("Message")).isRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value class. Value should be the subtype of the expected value. Expected:<java.util.RandomAccess> but was:<java.util.LinkedList>.");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isNotRandomAccessTest() {
        new ListAssertion(new LinkedList<String>(), new FailDescription()).isNotRandomAccess();

        try {
            new ListAssertion(null, new FailDescription()).isNotRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ListAssertion(new ArrayList<String>(), new FailDescription()).isNotRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should not be the subtype of the expected value. Expected:<java.util.RandomAccess> but was:<java.util.ArrayList>.");
        }
        try {
            new ListAssertion(new ArrayList<String>(), new FailDescription().addMessage("Message")).isNotRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value class. Value should not be the subtype of the expected value. Expected:<java.util.RandomAccess> but was:<java.util.ArrayList>.");
        }
    }

}
