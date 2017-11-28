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

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ListAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ListAssertionTest extends AssertionTest {

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
    public void actualValueValidatorTest() {
        initialize(Raw.<String>listAssertion(), new ArrayList<String>());

        try {
            initialize(Raw.<String>listAssertion(), new Object());
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.<String>listAssertion(), new Object(), "Message");
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isRandomAccessTest() {
        initialize(Raw.<String>listAssertion(), new ArrayList<String>()).isRandomAccess();

        try {
            initialize(Raw.<String>listAssertion(), null).isRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").isRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), new LinkedList<String>()).isRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should be the subtype of the expected value. Expected:<java.util.RandomAccess> but was:<java.util.LinkedList>");
        }
        try {
            initialize(Raw.<String>listAssertion(), new LinkedList<String>(), "Message").isRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value class. Value should be the subtype of the expected value. Expected:<java.util.RandomAccess> but was:<java.util.LinkedList>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isNotRandomAccessTest() {
        initialize(Raw.<String>listAssertion(), new LinkedList<String>()).isNotRandomAccess();

        try {
            initialize(Raw.<String>listAssertion(), null).isNotRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").isNotRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), new ArrayList<String>()).isNotRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should not be the subtype of the expected value. Expected:<java.util.RandomAccess> but was:<java.util.ArrayList>");
        }
        try {
            initialize(Raw.<String>listAssertion(), new ArrayList<String>(), "Message").isNotRandomAccess();
            Assertions.fail("ListAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value class. Value should not be the subtype of the expected value. Expected:<java.util.RandomAccess> but was:<java.util.ArrayList>");
        }
    }

}
