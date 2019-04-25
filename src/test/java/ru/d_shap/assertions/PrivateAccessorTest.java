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
package ru.d_shap.assertions;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(PrivateAccessor.class).hasOnePrivateConstructor();
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getFieldWithObjectTest() throws Exception {
        ParentClass parentClass = new ParentClass();

        Field nullFieldParent = PrivateAccessor.getField(parentClass, "_nullField");
        Object nullFieldParentValue = nullFieldParent.get(parentClass);
        Assertions.assertThat(nullFieldParentValue).isNull();

        Field parentFieldParent = PrivateAccessor.getField(parentClass, "_parentField");
        Object parentFieldParentValue = parentFieldParent.get(parentClass);
        Assertions.assertThat(parentFieldParentValue).isEqualTo("parentField");

        ChildClass childClass = new ChildClass();

        Field nullFieldChild = PrivateAccessor.getField(childClass, "_nullField");
        Object nullFieldChildValue = nullFieldChild.get(childClass);
        Assertions.assertThat(nullFieldChildValue).isNull();

        Field parentFieldChild = PrivateAccessor.getField(childClass, "_parentField");
        Object parentFieldChildValue = parentFieldChild.get(childClass);
        Assertions.assertThat(parentFieldChildValue).isEqualTo("parentField");

        Field childFieldChild = PrivateAccessor.getField(childClass, "_childField");
        Object childFieldChildValue = childFieldChild.get(childClass);
        Assertions.assertThat(childFieldChildValue).isEqualTo("childField");
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getFieldWithClassAndObjectTest() throws Exception {
        ParentClass parentClass = new ParentClass();

        Field nullStaticFieldParent = PrivateAccessor.getField(ParentClass.class, null, "NULL_STATIC_FIELD");
        Object nullStaticFieldParentValue = nullStaticFieldParent.get(null);
        Assertions.assertThat(nullStaticFieldParentValue).isNull();

        Field parentStaticFieldParent = PrivateAccessor.getField(ParentClass.class, null, "PARENT_STATIC_FIELD");
        Object parentStaticFieldParentValue = parentStaticFieldParent.get(null);
        Assertions.assertThat(parentStaticFieldParentValue).isEqualTo("parentStaticField");

        Field nullFieldParent = PrivateAccessor.getField(ParentClass.class, parentClass, "_nullField");
        Object nullFieldParentValue = nullFieldParent.get(parentClass);
        Assertions.assertThat(nullFieldParentValue).isNull();

        Field parentFieldParent = PrivateAccessor.getField(ParentClass.class, parentClass, "_parentField");
        Object parentFieldParentValue = parentFieldParent.get(parentClass);
        Assertions.assertThat(parentFieldParentValue).isEqualTo("parentField");

        ChildClass childClass = new ChildClass();

        Field nullStaticFieldChild = PrivateAccessor.getField(ChildClass.class, null, "NULL_STATIC_FIELD");
        Object nullStaticFieldChildValue = nullStaticFieldChild.get(null);
        Assertions.assertThat(nullStaticFieldChildValue).isNull();

        Field parentStaticFieldChild = PrivateAccessor.getField(ChildClass.class, null, "PARENT_STATIC_FIELD");
        Object parentStaticFieldChildValue = parentStaticFieldChild.get(null);
        Assertions.assertThat(parentStaticFieldChildValue).isEqualTo("parentStaticField");

        Field childStaticFieldChild = PrivateAccessor.getField(ChildClass.class, null, "CHILD_STATIC_FIELD");
        Object childStaticFieldChildValue = childStaticFieldChild.get(null);
        Assertions.assertThat(childStaticFieldChildValue).isEqualTo("childStaticField");

        Field nullFieldChild = PrivateAccessor.getField(ChildClass.class, childClass, "_nullField");
        Object nullFieldChildValue = nullFieldChild.get(childClass);
        Assertions.assertThat(nullFieldChildValue).isNull();

        Field parentFieldChild = PrivateAccessor.getField(ChildClass.class, childClass, "_parentField");
        Object parentFieldChildValue = parentFieldChild.get(childClass);
        Assertions.assertThat(parentFieldChildValue).isEqualTo("parentField");

        Field childField = PrivateAccessor.getField(ChildClass.class, childClass, "_childField");
        Object childFieldValue = childField.get(childClass);
        Assertions.assertThat(childFieldValue).isEqualTo("childField");
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NoSuchFieldException.class)
    public void getFieldWrongNameFailTest() throws Exception {
        PrivateAccessor.getField(new ChildClass(), "wrongFieldName");
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getFieldValueWithObjectTest() throws Exception {
        ParentClass parentClass = new ParentClass();

        Object nullFieldParentValue = PrivateAccessor.getFieldValue(parentClass, "_nullField");
        Assertions.assertThat(nullFieldParentValue).isNull();

        Object parentFieldParentValue = PrivateAccessor.getFieldValue(parentClass, "_parentField");
        Assertions.assertThat(parentFieldParentValue).isEqualTo("parentField");

        ChildClass childClass = new ChildClass();

        Object nullFieldChildValue = PrivateAccessor.getFieldValue(childClass, "_nullField");
        Assertions.assertThat(nullFieldChildValue).isNull();

        Object parentFieldChildValue = PrivateAccessor.getFieldValue(childClass, "_parentField");
        Assertions.assertThat(parentFieldChildValue).isEqualTo("parentField");

        Object childFieldChildValue = PrivateAccessor.getFieldValue(childClass, "_childField");
        Assertions.assertThat(childFieldChildValue).isEqualTo("childField");
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getFieldValueWithClassAndObjectTest() throws Exception {
        ParentClass parentClass = new ParentClass();

        Object nullStaticFieldParentValue = PrivateAccessor.getFieldValue(ParentClass.class, null, "NULL_STATIC_FIELD");
        Assertions.assertThat(nullStaticFieldParentValue).isNull();

        Object parentStaticFieldParentValue = PrivateAccessor.getFieldValue(ParentClass.class, null, "PARENT_STATIC_FIELD");
        Assertions.assertThat(parentStaticFieldParentValue).isEqualTo("parentStaticField");

        Object nullFieldParentValue = PrivateAccessor.getFieldValue(ParentClass.class, parentClass, "_nullField");
        Assertions.assertThat(nullFieldParentValue).isNull();

        Object parentFieldParentValue = PrivateAccessor.getFieldValue(ParentClass.class, parentClass, "_parentField");
        Assertions.assertThat(parentFieldParentValue).isEqualTo("parentField");

        ChildClass childClass = new ChildClass();

        Object nullStaticFieldChildValue = PrivateAccessor.getFieldValue(ChildClass.class, null, "NULL_STATIC_FIELD");
        Assertions.assertThat(nullStaticFieldChildValue).isNull();

        Object parentStaticFieldChildValue = PrivateAccessor.getFieldValue(ChildClass.class, null, "PARENT_STATIC_FIELD");
        Assertions.assertThat(parentStaticFieldChildValue).isEqualTo("parentStaticField");

        Object childStaticFieldChildValue = PrivateAccessor.getFieldValue(ChildClass.class, null, "CHILD_STATIC_FIELD");
        Assertions.assertThat(childStaticFieldChildValue).isEqualTo("childStaticField");

        Object nullFieldChildValue = PrivateAccessor.getFieldValue(ChildClass.class, childClass, "_nullField");
        Assertions.assertThat(nullFieldChildValue).isNull();

        Object parentFieldChildValue = PrivateAccessor.getFieldValue(ChildClass.class, childClass, "_parentField");
        Assertions.assertThat(parentFieldChildValue).isEqualTo("parentField");

        Object childFieldValue = PrivateAccessor.getFieldValue(ChildClass.class, childClass, "_childField");
        Assertions.assertThat(childFieldValue).isEqualTo("childField");
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getMethodWithObjectTest() throws Exception {
        ParentClass parentClass = new ParentClass();

        Method parentMethodParent = PrivateAccessor.getMethod(parentClass, "parentMethod");
        Object parentMethodParentValue = parentMethodParent.invoke(parentClass);
        Assertions.assertThat(parentMethodParentValue).isEqualTo("parentMethod");

        ChildClass childClass = new ChildClass();

        Method parentMethodChild = PrivateAccessor.getMethod(childClass, "parentMethod");
        Object parentMethodChildValue = parentMethodChild.invoke(childClass);
        Assertions.assertThat(parentMethodChildValue).isEqualTo("parentMethod");

        Method childMethodChild = PrivateAccessor.getMethod(childClass, "childMethod", String.class);
        Object childMethodChildValue = childMethodChild.invoke(childClass, "param");
        Assertions.assertThat(childMethodChildValue).isEqualTo("childMethod:param");
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getMethodWithClassAndObjectTest() throws Exception {
        ParentClass parentClass = new ParentClass();

        Method parentStaticMethodParent = PrivateAccessor.getMethod(ParentClass.class, null, "parentStaticMethod");
        Object parentStaticMethodParentValue = parentStaticMethodParent.invoke(null);
        Assertions.assertThat(parentStaticMethodParentValue).isEqualTo("parentStaticMethod");

        Method parentMethodParent = PrivateAccessor.getMethod(ParentClass.class, parentClass, "parentMethod");
        Object parentMethodParentValue = parentMethodParent.invoke(parentClass);
        Assertions.assertThat(parentMethodParentValue).isEqualTo("parentMethod");

        ChildClass childClass = new ChildClass();

        Method parentStaticMethodChild = PrivateAccessor.getMethod(ChildClass.class, null, "parentStaticMethod");
        Object parentStaticMethodChildValue = parentStaticMethodChild.invoke(null);
        Assertions.assertThat(parentStaticMethodChildValue).isEqualTo("parentStaticMethod");

        Method childStaticMethodChild = PrivateAccessor.getMethod(ChildClass.class, null, "childStaticMethod", String.class);
        Object childStaticMethodChildValue = childStaticMethodChild.invoke(null, "param");
        Assertions.assertThat(childStaticMethodChildValue).isEqualTo("childStaticMethod:param");

        Method parentMethodChild = PrivateAccessor.getMethod(ChildClass.class, childClass, "parentMethod");
        Object parentMethodChildValue = parentMethodChild.invoke(childClass);
        Assertions.assertThat(parentMethodChildValue).isEqualTo("parentMethod");

        Method childMethodChild = PrivateAccessor.getMethod(ChildClass.class, childClass, "childMethod", String.class);
        Object childMethodChildValue = childMethodChild.invoke(childClass, "param");
        Assertions.assertThat(childMethodChildValue).isEqualTo("childMethod:param");
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NoSuchMethodException.class)
    public void getMethodWrongNameFailTest() throws Exception {
        PrivateAccessor.getMethod(new ChildClass(), "wrongMethodName");
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getConstructorWithClassTest() throws Exception {
        Constructor<PrivateConstructorClass> constructor = PrivateAccessor.getConstructor(PrivateConstructorClass.class);
        PrivateConstructorClass object = constructor.newInstance();
        Assertions.assertThat(object).isNotNull();
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NoSuchMethodException.class)
    public void getConstructorWrongNameFailTest() throws Exception {
        PrivateAccessor.getConstructor(ChildClass.class, String.class);
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void setAccessibleFieldTest() throws Exception {
        ParentClass parentClass = new ParentClass();
        Field field = parentClass.getClass().getDeclaredField("_parentField");
        try {
            field.get(parentClass);
            Assertions.fail("PrivateAccessor test fail");
        } catch (IllegalAccessException ex) {
            Assertions.assertThat(ex).toMessage().contains("with modifiers \"private final\"");
        }
        PrivateAccessor.setAccessible(field);
        Object value = field.get(parentClass);
        Assertions.assertThat(value).isEqualTo("parentField");
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void setAccessibleMethodTest() throws Exception {
        ParentClass parentClass = new ParentClass();
        Method method = parentClass.getClass().getDeclaredMethod("parentMethod");
        try {
            method.invoke(parentClass);
            Assertions.fail("PrivateAccessor test fail");
        } catch (IllegalAccessException ex) {
            Assertions.assertThat(ex).toMessage().contains("with modifiers \"private\"");
        }
        PrivateAccessor.setAccessible(method);
        Object value = method.invoke(parentClass);
        Assertions.assertThat(value).isEqualTo("parentMethod");
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void setAccessibleConstructorTest() throws Exception {
        Constructor<PrivateConstructorClass> constructor = PrivateConstructorClass.class.getDeclaredConstructor();
        try {
            constructor.newInstance();
            Assertions.fail("PrivateAccessor test fail");
        } catch (IllegalAccessException ex) {
            Assertions.assertThat(ex).toMessage().contains("with modifiers \"private\"");
        }
        PrivateAccessor.setAccessible(constructor);
        PrivateConstructorClass privateConstructor = constructor.newInstance();
        Assertions.assertThat(privateConstructor).isNotNull();
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ParentClass {

        private static final String NULL_STATIC_FIELD = null;

        private static final String PARENT_STATIC_FIELD = "parentStaticField";

        private final String _nullField;

        private final String _parentField;

        ParentClass() {
            super();
            _nullField = null;
            _parentField = "parentField";
        }

        private static String parentStaticMethod() {
            return "parentStaticMethod";
        }

        private String parentMethod() {
            return "parentMethod";
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ChildClass extends ParentClass {

        private static final String CHILD_STATIC_FIELD = "childStaticField";

        private final String _childField;

        ChildClass() {
            super();
            _childField = "childField";
        }

        private static String childStaticMethod(final String param) {
            return "childStaticMethod:" + param;
        }

        private String childMethod(final String param) {
            return "childMethod:" + param;
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class PrivateConstructorClass {

        private PrivateConstructorClass() {
            super();
        }

    }

}
