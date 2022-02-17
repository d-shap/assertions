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
package ru.d_shap.assertions.util;

import java.io.NotSerializableException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link SerializationHelper}.
 *
 * @author Dmitry Shapovalov
 */
public final class SerializationHelperTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public SerializationHelperTest() {
        super();
    }

    /**
     * {@link SerializationHelper} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(SerializationHelper.class).hasOnePrivateConstructor();
    }

    /**
     * {@link SerializationHelper} class test.
     */
    @Test
    public void serializeAndDeserializeTest() {
        Integer value1 = 5;
        Integer dValue1 = SerializationHelper.serializeAndDeserialize(value1);
        Assertions.assertThat(dValue1).isNotSameAs(value1);
        Assertions.assertThat(dValue1).isEqualTo(value1);

        List<String> value2 = new ArrayList<>();
        value2.add("val1");
        value2.add("val2");
        value2.add("val3");
        List<String> dValue2 = SerializationHelper.serializeAndDeserialize(value2);
        Assertions.assertThat(dValue2).isNotSameAs(value2);
        Assertions.assertThat(dValue2).containsExactlyInOrder("val1", "val2", "val3");

        try {
            Object value = new Object();
            SerializationHelper.serializeAndDeserialize(value);
            Assertions.fail("SerializationHelper test fail");
        } catch (SerializationException ex) {
            Assertions.assertThat(ex).hasMessage("java.lang.Object");
            Assertions.assertThat(ex).hasCause(NotSerializableException.class);
        }

        try {
            List<Object> value = new ArrayList<>();
            value.add("str");
            value.add(5);
            value.add(new Object[]{new Object()});
            value.add(5);
            SerializationHelper.serializeAndDeserialize(value);
            Assertions.fail("SerializationHelper test fail");
        } catch (SerializationException ex) {
            Assertions.assertThat(ex).hasMessage("java.lang.Object");
            Assertions.assertThat(ex).hasCause(NotSerializableException.class);
        }
    }

}
