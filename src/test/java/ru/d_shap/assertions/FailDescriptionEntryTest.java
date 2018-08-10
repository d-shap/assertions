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

import org.junit.Test;

/**
 * Tests for {@link FailDescriptionEntry}.
 *
 * @author Dmitry Shapovalov
 */
public final class FailDescriptionEntryTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FailDescriptionEntryTest() {
        super();
    }

    /**
     * {@link FailDescriptionEntry} class test.
     */
    @Test
    public void addFormattedMessageTest() {
        Assertions.assertThat(getFormattedMessages(null, new Object[]{}, false)).containsExactlyInOrder();
        Assertions.assertThat(getFormattedMessages("", new Object[]{}, false)).containsExactlyInOrder();
        Assertions.assertThat(getFormattedMessages(" ", new Object[]{}, false)).containsExactlyInOrder(" ");
        Assertions.assertThat(getFormattedMessages("  ", new Object[]{}, false)).containsExactlyInOrder("  ");
        Assertions.assertThat(getFormattedMessages("\t", new Object[]{}, false)).containsExactlyInOrder("\t");

        Assertions.assertThat(getFormattedMessages(null, new Object[]{}, true)).containsExactlyInOrder();
        Assertions.assertThat(getFormattedMessages("", new Object[]{}, true)).containsExactlyInOrder();
        Assertions.assertThat(getFormattedMessages(" ", new Object[]{}, true)).containsExactlyInOrder(" .");
        Assertions.assertThat(getFormattedMessages("  ", new Object[]{}, true)).containsExactlyInOrder("  .");
        Assertions.assertThat(getFormattedMessages("\t", new Object[]{}, true)).containsExactlyInOrder("\t.");

        Assertions.assertThat(getFormattedMessages("message", new Object[]{}, false)).containsExactlyInOrder("message");
        Assertions.assertThat(getFormattedMessages("message.", new Object[]{}, false)).containsExactlyInOrder("message.");
        Assertions.assertThat(getFormattedMessages("message?", new Object[]{}, false)).containsExactlyInOrder("message?");
        Assertions.assertThat(getFormattedMessages("message!", new Object[]{}, false)).containsExactlyInOrder("message!");
        Assertions.assertThat(getFormattedMessages("message:", new Object[]{}, false)).containsExactlyInOrder("message:");

        Assertions.assertThat(getFormattedMessages("message", new Object[]{}, true)).containsExactlyInOrder("message.");
        Assertions.assertThat(getFormattedMessages("message.", new Object[]{}, true)).containsExactlyInOrder("message.");
        Assertions.assertThat(getFormattedMessages("message?", new Object[]{}, true)).containsExactlyInOrder("message?");
        Assertions.assertThat(getFormattedMessages("message!", new Object[]{}, true)).containsExactlyInOrder("message!");
        Assertions.assertThat(getFormattedMessages("message:", new Object[]{}, true)).containsExactlyInOrder("message:.");

        Assertions.assertThat(getFormattedMessages("message {0}", new Object[]{null}, false)).containsExactlyInOrder("message null");

        Assertions.assertThat(getFormattedMessages("message {0}", new Object[]{null}, true)).containsExactlyInOrder("message null.");

        Assertions.assertThat(getFormattedMessages("message {1} : {0}", new Object[]{1, "value"}, false)).containsExactlyInOrder("message value : 1");
        Assertions.assertThat(getFormattedMessages("message '{1}' : '{0}'", new Object[]{1, "value"}, false)).containsExactlyInOrder("message {1} : {0}");
        Assertions.assertThat(getFormattedMessages("message ''{1}'' : ''{0}''", new Object[]{1, "value"}, false)).containsExactlyInOrder("message 'value' : '1'");

        Assertions.assertThat(getFormattedMessages("message {1} : {0}", new Object[]{1, "value"}, true)).containsExactlyInOrder("message value : 1.");
        Assertions.assertThat(getFormattedMessages("message '{1}' : '{0}'", new Object[]{1, "value"}, true)).containsExactlyInOrder("message {1} : {0}.");
        Assertions.assertThat(getFormattedMessages("message ''{1}'' : ''{0}''", new Object[]{1, "value"}, true)).containsExactlyInOrder("message 'value' : '1'.");

        Assertions.assertThat(getFormattedMessages("message {1} : {0}", new Object[]{1}, false)).containsExactlyInOrder("message {1} : 1");
        Assertions.assertThat(getFormattedMessages("message {1} : {0}", new Object[]{1, "value", "ignore"}, false)).containsExactlyInOrder("message value : 1");

        Assertions.assertThat(getFormattedMessages("message {1} : {0}", new Object[]{1}, true)).containsExactlyInOrder("message {1} : 1.");
        Assertions.assertThat(getFormattedMessages("message {1} : {0}", new Object[]{1, "value", "ignore"}, true)).containsExactlyInOrder("message value : 1.");
    }

    /**
     * {@link FailDescriptionEntry} class test.
     */
    @Test(expected = NullPointerException.class)
    public void nullArgumentsFailTest() {
        new FailDescriptionEntry("", null, false);
    }

    /**
     * {@link FailDescriptionEntry} class test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void convertArgumentToStringTest() {
        getFormattedMessages("{0,number,integer}", new Object[]{1}, true);
    }

}