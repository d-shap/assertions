///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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
        new ListAssertion(new ArrayList<String>(), null).isRandomAccess();

        try {
            new ListAssertion(null, null).isRandomAccess();
            Assertions.fail("List assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ListAssertion(new LinkedList<String>(), null).isRandomAccess();
            Assertions.fail("List assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.util.RandomAccess> but was:<java.util.LinkedList>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isNotRandomAccessTest() {
        new ListAssertion(new LinkedList<String>(), null).isNotRandomAccess();

        try {
            new ListAssertion(null, null).isNotRandomAccess();
            Assertions.fail("List assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ListAssertion(new ArrayList<String>(), null).isNotRandomAccess();
            Assertions.fail("List assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.util.RandomAccess> but was:<java.util.ArrayList>");
        }
    }

}
