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

import java.lang.reflect.Field;

import org.junit.Test;

/**
 * Tests for {@link PrivateAccessor}.
 *
 * @author Dmitry Shapovalov
 */
public final class PrivateAccessorTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public PrivateAccessorTest() {
        super();
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws NoSuchFieldException   no such field exception.
     * @throws IllegalAccessException illegal access exception.
     */
    @Test
    public void setAccessibleTest() throws NoSuchFieldException, IllegalAccessException {
        Object object = new Object();
        BaseAssertion<Object> baseAssertion = createBaseAssertion(object, "message");

        Field actualField = baseAssertion.getClass().getSuperclass().getDeclaredField("_actual");
        try {
            actualField.get(baseAssertion);
            Assertions.fail("FieldAccessAction test fail");
        } catch (IllegalAccessException ex) {
            Assertions.assertThat(ex).toMessage().contains("private");
        }
        PrivateAccessor.setAccessible(actualField);
        Object actualValue = actualField.get(baseAssertion);
        Assertions.assertThat(actualValue).isSameAs(object);

        Field failDescriptionField = baseAssertion.getClass().getSuperclass().getDeclaredField("_failDescription");
        try {
            failDescriptionField.get(baseAssertion);
            Assertions.fail("FieldAccessAction test fail");
        } catch (IllegalAccessException ex) {
            Assertions.assertThat(ex).toMessage().contains("private");
        }
        PrivateAccessor.setAccessible(failDescriptionField);
        Object failDescriptionValue = failDescriptionField.get(baseAssertion);
        Assertions.assertThat(failDescriptionValue).isInstanceOf(FailDescription.class);
        Assertions.assertThat(((FailDescription) failDescriptionValue).createAssertionError()).hasMessage("message.");
    }

}
