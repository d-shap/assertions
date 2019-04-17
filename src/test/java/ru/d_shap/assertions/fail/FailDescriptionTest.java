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
package ru.d_shap.assertions.fail;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link FailDescription}.
 *
 * @author Dmitry Shapovalov
 */
public final class FailDescriptionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FailDescriptionTest() {
        super();
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void getFullMessageTest() {
        Assertions.assertThat(new FailDescription().getFullMessage()).isEqualTo("");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void getFullMessageWithMessageAndArgumentsTest() {
        Assertions.assertThat(new FailDescription((String) null).getFullMessage()).isEqualTo("");
        Assertions.assertThat(new FailDescription(null, 1).getFullMessage()).isEqualTo("");
        Assertions.assertThat(new FailDescription("").getFullMessage()).isEqualTo("");
        Assertions.assertThat(new FailDescription("", 1).getFullMessage()).isEqualTo("");
        Assertions.assertThat(new FailDescription(" ").getFullMessage()).isEqualTo(" .");
        Assertions.assertThat(new FailDescription("message").getFullMessage()).isEqualTo("message.");
        Assertions.assertThat(new FailDescription("message: {0}", 1).getFullMessage()).isEqualTo("message: 1.");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void getFullMessageWithFailDescriptionEntryTest() {
        Assertions.assertThat(new FailDescription(new FailDescriptionEntry(null, new Object[]{}, false)).getFullMessage()).isEqualTo("");
        Assertions.assertThat(new FailDescription(new FailDescriptionEntry(null, new Object[]{1}, false)).getFullMessage()).isEqualTo("");
        Assertions.assertThat(new FailDescription(new FailDescriptionEntry("", new Object[]{}, false)).getFullMessage()).isEqualTo("");
        Assertions.assertThat(new FailDescription(new FailDescriptionEntry("", new Object[]{1}, false)).getFullMessage()).isEqualTo("");
        Assertions.assertThat(new FailDescription(new FailDescriptionEntry(" ", new Object[]{}, false)).getFullMessage()).isEqualTo(" ");
        Assertions.assertThat(new FailDescription(new FailDescriptionEntry("message", new Object[]{}, false)).getFullMessage()).isEqualTo("message");
        Assertions.assertThat(new FailDescription(new FailDescriptionEntry("message: {0}", new Object[]{1}, false)).getFullMessage()).isEqualTo("message: 1");

        Assertions.assertThat(new FailDescription(new FailDescriptionEntry(null, new Object[]{}, true)).getFullMessage()).isEqualTo("");
        Assertions.assertThat(new FailDescription(new FailDescriptionEntry(null, new Object[]{1}, true)).getFullMessage()).isEqualTo("");
        Assertions.assertThat(new FailDescription(new FailDescriptionEntry("", new Object[]{}, true)).getFullMessage()).isEqualTo("");
        Assertions.assertThat(new FailDescription(new FailDescriptionEntry("", new Object[]{1}, true)).getFullMessage()).isEqualTo("");
        Assertions.assertThat(new FailDescription(new FailDescriptionEntry(" ", new Object[]{}, true)).getFullMessage()).isEqualTo(" .");
        Assertions.assertThat(new FailDescription(new FailDescriptionEntry("message", new Object[]{}, true)).getFullMessage()).isEqualTo("message.");
        Assertions.assertThat(new FailDescription(new FailDescriptionEntry("message: {0}", new Object[]{1}, true)).getFullMessage()).isEqualTo("message: 1.");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void getFullMessageWithFailDescriptionTest() {
        FailDescription failDescription1 = new FailDescription("message1");
        Assertions.assertThat(failDescription1.getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(new FailDescription(failDescription1).getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(failDescription1.getFullMessage()).isEqualTo("message1.");

        FailDescription failDescription2 = new FailDescription(failDescription1, "message2: {0}", 2);
        Assertions.assertThat(failDescription2.getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(new FailDescription(failDescription2).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(failDescription2.getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void getFullMessageWithFailDescriptionAndMessageAndArgumentsTest() {
        FailDescription failDescription1 = new FailDescription("message1");
        Assertions.assertThat(failDescription1.getFullMessage()).isEqualTo("message1.");

        Assertions.assertThat(new FailDescription(failDescription1, (String) null).getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(new FailDescription(failDescription1, null, 1).getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(new FailDescription(failDescription1, "").getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(new FailDescription(failDescription1, "", 1).getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(new FailDescription(failDescription1, " ").getFullMessage()).isEqualTo("message1.\n\t .");
        Assertions.assertThat(new FailDescription(failDescription1, "message").getFullMessage()).isEqualTo("message1.\n\tmessage.");
        Assertions.assertThat(new FailDescription(failDescription1, "message: {0}", 1).getFullMessage()).isEqualTo("message1.\n\tmessage: 1.");

        Assertions.assertThat(failDescription1.getFullMessage()).isEqualTo("message1.");

        FailDescription failDescription2 = new FailDescription(failDescription1, "message2: {0}", 2);
        Assertions.assertThat(failDescription2.getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");

        Assertions.assertThat(new FailDescription(failDescription2, (String) null).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(new FailDescription(failDescription2, null, 1).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(new FailDescription(failDescription2, "").getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(new FailDescription(failDescription2, "", 1).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(new FailDescription(failDescription2, " ").getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.\n\t .");
        Assertions.assertThat(new FailDescription(failDescription2, "message").getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.\n\tmessage.");
        Assertions.assertThat(new FailDescription(failDescription2, "message: {0}", 1).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.\n\tmessage: 1.");

        Assertions.assertThat(failDescription2.getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void getFullMessageWithFailDescriptionAndFailDescriptionEntryTest() {
        FailDescription failDescription1 = new FailDescription("message1");
        Assertions.assertThat(failDescription1.getFullMessage()).isEqualTo("message1.");

        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry(null, new Object[]{}, false)).getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry(null, new Object[]{1}, false)).getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry("", new Object[]{}, false)).getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry("", new Object[]{1}, false)).getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry(" ", new Object[]{}, false)).getFullMessage()).isEqualTo("message1.\n\t ");
        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry("message", new Object[]{}, false)).getFullMessage()).isEqualTo("message1.\n\tmessage");
        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry("message: {0}", new Object[]{1}, false)).getFullMessage()).isEqualTo("message1.\n\tmessage: 1");

        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry(null, new Object[]{}, true)).getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry(null, new Object[]{1}, true)).getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry("", new Object[]{}, true)).getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry("", new Object[]{1}, true)).getFullMessage()).isEqualTo("message1.");
        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry(" ", new Object[]{}, true)).getFullMessage()).isEqualTo("message1.\n\t .");
        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry("message", new Object[]{}, true)).getFullMessage()).isEqualTo("message1.\n\tmessage.");
        Assertions.assertThat(new FailDescription(failDescription1, new FailDescriptionEntry("message: {0}", new Object[]{1}, true)).getFullMessage()).isEqualTo("message1.\n\tmessage: 1.");

        Assertions.assertThat(failDescription1.getFullMessage()).isEqualTo("message1.");

        FailDescription failDescription2 = new FailDescription(failDescription1, "message2: {0}", 2);
        Assertions.assertThat(failDescription2.getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");

        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry(null, new Object[]{}, false)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry(null, new Object[]{1}, false)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry("", new Object[]{}, false)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry("", new Object[]{1}, false)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry(" ", new Object[]{}, false)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.\n\t ");
        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry("message", new Object[]{}, false)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.\n\tmessage");
        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry("message: {0}", new Object[]{1}, false)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.\n\tmessage: 1");

        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry(null, new Object[]{}, true)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry(null, new Object[]{1}, true)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry("", new Object[]{}, true)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry("", new Object[]{1}, true)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry(" ", new Object[]{}, true)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.\n\t .");
        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry("message", new Object[]{}, true)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.\n\tmessage.");
        Assertions.assertThat(new FailDescription(failDescription2, new FailDescriptionEntry("message: {0}", new Object[]{1}, true)).getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.\n\tmessage: 1.");

        Assertions.assertThat(failDescription2.getFullMessage()).isEqualTo("message1.\n\tmessage2: 2.");
    }

}
