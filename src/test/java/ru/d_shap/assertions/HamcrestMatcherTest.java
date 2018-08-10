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
package ru.d_shap.assertions;

import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link HamcrestMatcher}.
 *
 * @author Dmitry Shapovalov
 */
public final class HamcrestMatcherTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public HamcrestMatcherTest() {
        super();
    }

    /**
     * {@link HamcrestMatcherTest} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(HamcrestMatcher.class).hasOnePrivateConstructor();
    }

    /**
     * {@link HamcrestMatcher} class test.
     */
    @Test
    public void matcherAssertionTest() {
        HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(10));

        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11));
            Assertions.fail("HamcrestMatcher test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: <11>\n     but: was <10>");
        }
    }

    /**
     * {@link HamcrestMatcher} class test.
     */
    @Test
    public void matcherAssertionWithMessageTest() {
        HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(10), "message: {0}", 1);

        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11), "message: {0}", 1);
            Assertions.fail("HamcrestMatcher test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("message: 1.\nExpected: <11>\n     but: was <10>");
        }
    }

    /**
     * {@link HamcrestMatcher} class test.
     */
    @Test
    public void matcherAssertionWithFailDescriptionTest() {
        HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(10), new FailDescription("message"));

        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11), new FailDescription("message"));
            Assertions.fail("HamcrestMatcher test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("message.\nExpected: <11>\n     but: was <10>");
        }
    }

    /**
     * {@link HamcrestMatcher} class test.
     */
    @Test
    public void matcherAssertionWithFailDescriptionAndMesageTest() {
        HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(10), new FailDescription("message1"), "message2: {0}", 1);

        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11), new FailDescription("message1"), "message2: {0}", 1);
            Assertions.fail("HamcrestMatcher test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("message1.\n\tmessage2: 1.\nExpected: <11>\n     but: was <10>");
        }
    }

    /**
     * {@link HamcrestMatcher} class test.
     */
    @Test
    public void genericsTest() {
        HamcrestMatcher.matcherAssertion(createClassA(), createMatcherA());
        HamcrestMatcher.matcherAssertion(createClassB(), createMatcherA());
        HamcrestMatcher.matcherAssertion(createClassC(), createMatcherA());

        HamcrestMatcher.matcherAssertion(createClassB(), createMatcherB());
        HamcrestMatcher.matcherAssertion(createClassC(), createMatcherB());

        HamcrestMatcher.matcherAssertion(createClassC(), createMatcherC());
    }

}
