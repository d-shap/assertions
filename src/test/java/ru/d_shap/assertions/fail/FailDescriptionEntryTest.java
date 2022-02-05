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
package ru.d_shap.assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

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
        Assertions.assertThat(getFormattedMessages("value''s", new Object[]{}, false)).containsExactlyInOrder("value's");

        Assertions.assertThat(getFormattedMessages(null, new Object[]{}, true)).containsExactlyInOrder();
        Assertions.assertThat(getFormattedMessages("", new Object[]{}, true)).containsExactlyInOrder();
        Assertions.assertThat(getFormattedMessages(" ", new Object[]{}, true)).containsExactlyInOrder(" .");
        Assertions.assertThat(getFormattedMessages("  ", new Object[]{}, true)).containsExactlyInOrder("  .");
        Assertions.assertThat(getFormattedMessages("\t", new Object[]{}, true)).containsExactlyInOrder("\t.");
        Assertions.assertThat(getFormattedMessages("value''s", new Object[]{}, true)).containsExactlyInOrder("value's.");

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

        Assertions.assertThat(getFormattedMessages("message {0}", new Object[]{null}, false)).containsExactlyInOrder("message <NULL>");
        Assertions.assertThat(getFormattedMessages("{0}", new Object[]{null}, false)).containsExactlyInOrder();

        Assertions.assertThat(getFormattedMessages("message {0}", new Object[]{null}, true)).containsExactlyInOrder("message <NULL>.");
        Assertions.assertThat(getFormattedMessages("{0}", new Object[]{null}, true)).containsExactlyInOrder();

        Assertions.assertThat(getFormattedMessages(null, new Object[]{}, false)).containsExactlyInOrder();
        Assertions.assertThat(getFormattedMessages("", new Object[]{}, false)).containsExactlyInOrder();

        Assertions.assertThat(getFormattedMessages(null, new Object[]{}, true)).containsExactlyInOrder();
        Assertions.assertThat(getFormattedMessages("", new Object[]{}, true)).containsExactlyInOrder();

        Assertions.assertThat(getFormattedMessages("message {1} : {0}", new Object[]{1, "value"}, false)).containsExactlyInOrder("message value : 1");
        Assertions.assertThat(getFormattedMessages("message '{1}' : '{0}'", new Object[]{}, false)).containsExactlyInOrder("message {1} : {0}");
        Assertions.assertThat(getFormattedMessages("message ''{1}'' : ''{0}''", new Object[]{1, "value"}, false)).containsExactlyInOrder("message 'value' : '1'");

        Assertions.assertThat(getFormattedMessages("message {1} : {0}", new Object[]{1, "value"}, true)).containsExactlyInOrder("message value : 1.");
        Assertions.assertThat(getFormattedMessages("message '{1}' : '{0}'", new Object[]{}, true)).containsExactlyInOrder("message {1} : {0}.");
        Assertions.assertThat(getFormattedMessages("message ''{1}'' : ''{0}''", new Object[]{1, "value"}, true)).containsExactlyInOrder("message 'value' : '1'.");
    }

    /**
     * {@link FailDescriptionEntry} class test.
     */
    @Test(expected = NullPointerException.class)
    public void nullArgumentsNullMessageFailTest() {
        new FailDescriptionEntry(null, null, false);
    }

    /**
     * {@link FailDescriptionEntry} class test.
     */
    @Test(expected = NullPointerException.class)
    public void nullArgumentsEmptyMessageFailTest() {
        new FailDescriptionEntry("", null, false);
    }

    /**
     * {@link FailDescriptionEntry} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void wrongArgumentCount0FailTest() {
        new FailDescriptionEntry("{0}", new Object[]{}, false);
    }

    /**
     * {@link FailDescriptionEntry} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void wrongArgumentCount1FailTest() {
        new FailDescriptionEntry("'{0}'", new Object[]{null}, false);
    }

    /**
     * {@link FailDescriptionEntry} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void wrongArgumentCount2FailTest() {
        new FailDescriptionEntry("{0}", new Object[]{1, "value"}, false);
    }

    /**
     * {@link FailDescriptionEntry} class test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void convertArgumentToStringFailTest() {
        getFormattedMessages("{0,number,integer}", new Object[]{1}, true);
    }

    private List<String> getFormattedMessages(final String message, final Object[] arguments, final boolean checkLastSymbol) {
        FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(message, arguments, checkLastSymbol);
        List<String> formattedMessages = new ArrayList<>();
        failDescriptionEntry.addFormattedMessage(formattedMessages);
        return formattedMessages;
    }

}
