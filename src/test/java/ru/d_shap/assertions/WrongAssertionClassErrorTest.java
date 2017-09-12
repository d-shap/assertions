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

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.collection.MapAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Tests for {@link WrongAssertionClassError}.
 *
 * @author Dmitry Shapovalov
 */
public final class WrongAssertionClassErrorTest {

    /**
     * Test class constructor.
     */
    public WrongAssertionClassErrorTest() {
        super();
    }

    /**
     * {@link WrongAssertionClassError} class test.
     */
    @Test
    public void errorMessageTest() {
        Assertions.assertThat(new WrongAssertionClassError(BaseAssertion.class, Object.class)).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertion - class should have one constructor BaseAssertion(java.lang.Object, java.lang.String)");
        Assertions.assertThat(new WrongAssertionClassError(IntAssertion.class, InputStream.class)).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.io.InputStream, java.lang.String)");
        Assertions.assertThat(new WrongAssertionClassError(MapAssertion.class, List.class)).hasMessage("Wrong assertion class: ru.d_shap.assertions.collection.MapAssertion - class should have one constructor MapAssertion(java.util.List, java.lang.String)");

        Assertions.assertThat(new WrongAssertionClassError(BaseAssertion.class, new IllegalAccessException())).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertion");
        Assertions.assertThat(new WrongAssertionClassError(IntAssertion.class, new IllegalAccessException())).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion");
        Assertions.assertThat(new WrongAssertionClassError(MapAssertion.class, new IllegalAccessException())).hasMessage("Wrong assertion class: ru.d_shap.assertions.collection.MapAssertion");

        Assertions.assertThat(new WrongAssertionClassError(BaseAssertion.class, new InvocationTargetException(new RuntimeException()))).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertion");
        Assertions.assertThat(new WrongAssertionClassError(IntAssertion.class, new InvocationTargetException(new RuntimeException()))).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion");
        Assertions.assertThat(new WrongAssertionClassError(MapAssertion.class, new InvocationTargetException(new RuntimeException()))).hasMessage("Wrong assertion class: ru.d_shap.assertions.collection.MapAssertion");

        Assertions.assertThat(new WrongAssertionClassError(BaseAssertion.class, new InstantiationException())).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertion");
        Assertions.assertThat(new WrongAssertionClassError(IntAssertion.class, new InstantiationException())).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion");
        Assertions.assertThat(new WrongAssertionClassError(MapAssertion.class, new InstantiationException())).hasMessage("Wrong assertion class: ru.d_shap.assertions.collection.MapAssertion");
    }

}
