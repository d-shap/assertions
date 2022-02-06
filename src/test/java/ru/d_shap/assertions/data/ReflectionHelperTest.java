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
package ru.d_shap.assertions.data;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ReflectionHelper}.
 *
 * @author Dmitry Shapovalov
 */
public final class ReflectionHelperTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ReflectionHelperTest() {
        super();
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(ReflectionHelper.class).hasOnePrivateConstructor();
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getFieldWithObjectTest() throws Exception {
        ParentClass parentClass = new ParentClass();

        Field nullFieldParent = ReflectionHelper.getField(parentClass, "_nullField");
        Object nullFieldParentValue = nullFieldParent.get(parentClass);
        Assertions.assertThat(nullFieldParentValue).isNull();

        Field parentFieldParent = ReflectionHelper.getField(parentClass, "_parentField");
        Object parentFieldParentValue = parentFieldParent.get(parentClass);
        Assertions.assertThat(parentFieldParentValue).isEqualTo("parentField");

        ChildClass childClass = new ChildClass();

        Field nullFieldChild = ReflectionHelper.getField(childClass, "_nullField");
        Object nullFieldChildValue = nullFieldChild.get(childClass);
        Assertions.assertThat(nullFieldChildValue).isNull();

        Field parentFieldChild = ReflectionHelper.getField(childClass, "_parentField");
        Object parentFieldChildValue = parentFieldChild.get(childClass);
        Assertions.assertThat(parentFieldChildValue).isEqualTo("parentField");

        Field childFieldChild = ReflectionHelper.getField(childClass, "_childField");
        Object childFieldChildValue = childFieldChild.get(childClass);
        Assertions.assertThat(childFieldChildValue).isEqualTo("childField");
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getFieldWithClassTest() throws Exception {
        ParentClass parentClass = new ParentClass();

        Field nullStaticFieldParent = ReflectionHelper.getField(ParentClass.class, "NULL_STATIC_FIELD");
        Object nullStaticFieldParentValue = nullStaticFieldParent.get(null);
        Assertions.assertThat(nullStaticFieldParentValue).isNull();

        Field parentStaticFieldParent = ReflectionHelper.getField(ParentClass.class, "PARENT_STATIC_FIELD");
        Object parentStaticFieldParentValue = parentStaticFieldParent.get(null);
        Assertions.assertThat(parentStaticFieldParentValue).isEqualTo("parentStaticField");

        Field nullFieldParent = ReflectionHelper.getField(ParentClass.class, "_nullField");
        Object nullFieldParentValue = nullFieldParent.get(parentClass);
        Assertions.assertThat(nullFieldParentValue).isNull();

        Field parentFieldParent = ReflectionHelper.getField(ParentClass.class, "_parentField");
        Object parentFieldParentValue = parentFieldParent.get(parentClass);
        Assertions.assertThat(parentFieldParentValue).isEqualTo("parentField");

        ChildClass childClass = new ChildClass();

        Field nullStaticFieldChild = ReflectionHelper.getField(ChildClass.class, "NULL_STATIC_FIELD");
        Object nullStaticFieldChildValue = nullStaticFieldChild.get(null);
        Assertions.assertThat(nullStaticFieldChildValue).isNull();

        Field parentStaticFieldChild = ReflectionHelper.getField(ChildClass.class, "PARENT_STATIC_FIELD");
        Object parentStaticFieldChildValue = parentStaticFieldChild.get(null);
        Assertions.assertThat(parentStaticFieldChildValue).isEqualTo("parentStaticField");

        Field childStaticFieldChild = ReflectionHelper.getField(ChildClass.class, "CHILD_STATIC_FIELD");
        Object childStaticFieldChildValue = childStaticFieldChild.get(null);
        Assertions.assertThat(childStaticFieldChildValue).isEqualTo("childStaticField");

        Field nullFieldChild = ReflectionHelper.getField(ChildClass.class, "_nullField");
        Object nullFieldChildValue = nullFieldChild.get(childClass);
        Assertions.assertThat(nullFieldChildValue).isNull();

        Field parentFieldChild = ReflectionHelper.getField(ChildClass.class, "_parentField");
        Object parentFieldChildValue = parentFieldChild.get(childClass);
        Assertions.assertThat(parentFieldChildValue).isEqualTo("parentField");

        Field childField = ReflectionHelper.getField(ChildClass.class, "_childField");
        Object childFieldValue = childField.get(childClass);
        Assertions.assertThat(childFieldValue).isEqualTo("childField");
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getFieldWrongNameFailTest() throws Exception {
        try {
            ReflectionHelper.getField(new ChildClass(), "wrongFieldName");
            Assertions.fail("PrivateAccessor test fail");
        } catch (ReflectionException ex) {
            Assertions.assertThat(ex).hasCause(NoSuchFieldException.class);
        }
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getFieldValueWithFieldTest() throws Exception {
        // TODO
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getFieldValueWithObjectTest() throws Exception {
        ParentClass parentClass = new ParentClass();

        Object nullFieldParentValue = ReflectionHelper.getFieldValue(parentClass, "_nullField");
        Assertions.assertThat(nullFieldParentValue).isNull();

        Object parentFieldParentValue = ReflectionHelper.getFieldValue(parentClass, "_parentField");
        Assertions.assertThat(parentFieldParentValue).isEqualTo("parentField");

        ChildClass childClass = new ChildClass();

        Object nullFieldChildValue = ReflectionHelper.getFieldValue(childClass, "_nullField");
        Assertions.assertThat(nullFieldChildValue).isNull();

        Object parentFieldChildValue = ReflectionHelper.getFieldValue(childClass, "_parentField");
        Assertions.assertThat(parentFieldChildValue).isEqualTo("parentField");

        Object childFieldChildValue = ReflectionHelper.getFieldValue(childClass, "_childField");
        Assertions.assertThat(childFieldChildValue).isEqualTo("childField");
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getFieldValueWithClassAndObjectTest() throws Exception {
        ParentClass parentClass = new ParentClass();

        Object nullStaticFieldParentValue = ReflectionHelper.getFieldValue(ParentClass.class, null, "NULL_STATIC_FIELD");
        Assertions.assertThat(nullStaticFieldParentValue).isNull();

        Object parentStaticFieldParentValue = ReflectionHelper.getFieldValue(ParentClass.class, null, "PARENT_STATIC_FIELD");
        Assertions.assertThat(parentStaticFieldParentValue).isEqualTo("parentStaticField");

        Object nullFieldParentValue = ReflectionHelper.getFieldValue(ParentClass.class, parentClass, "_nullField");
        Assertions.assertThat(nullFieldParentValue).isNull();

        Object parentFieldParentValue = ReflectionHelper.getFieldValue(ParentClass.class, parentClass, "_parentField");
        Assertions.assertThat(parentFieldParentValue).isEqualTo("parentField");

        ChildClass childClass = new ChildClass();

        Object nullStaticFieldChildValue = ReflectionHelper.getFieldValue(ChildClass.class, null, "NULL_STATIC_FIELD");
        Assertions.assertThat(nullStaticFieldChildValue).isNull();

        Object parentStaticFieldChildValue = ReflectionHelper.getFieldValue(ChildClass.class, null, "PARENT_STATIC_FIELD");
        Assertions.assertThat(parentStaticFieldChildValue).isEqualTo("parentStaticField");

        Object childStaticFieldChildValue = ReflectionHelper.getFieldValue(ChildClass.class, null, "CHILD_STATIC_FIELD");
        Assertions.assertThat(childStaticFieldChildValue).isEqualTo("childStaticField");

        Object nullFieldChildValue = ReflectionHelper.getFieldValue(ChildClass.class, childClass, "_nullField");
        Assertions.assertThat(nullFieldChildValue).isNull();

        Object parentFieldChildValue = ReflectionHelper.getFieldValue(ChildClass.class, childClass, "_parentField");
        Assertions.assertThat(parentFieldChildValue).isEqualTo("parentField");

        Object childFieldValue = ReflectionHelper.getFieldValue(ChildClass.class, childClass, "_childField");
        Assertions.assertThat(childFieldValue).isEqualTo("childField");
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getMethodWithObjectTest() throws Exception {
        ParentClass parentClass = new ParentClass();

        Method parentMethodParent = ReflectionHelper.getMethod(parentClass, "parentMethod");
        Object parentMethodParentValue = parentMethodParent.invoke(parentClass);
        Assertions.assertThat(parentMethodParentValue).isEqualTo("parentMethod");

        ChildClass childClass = new ChildClass();

        Method parentMethodChild = ReflectionHelper.getMethod(childClass, "parentMethod");
        Object parentMethodChildValue = parentMethodChild.invoke(childClass);
        Assertions.assertThat(parentMethodChildValue).isEqualTo("parentMethod");

        Method childMethodChild = ReflectionHelper.getMethod(childClass, "childMethod", String.class);
        Object childMethodChildValue = childMethodChild.invoke(childClass, "param");
        Assertions.assertThat(childMethodChildValue).isEqualTo("childMethod:param");
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getMethodWithClassTest() throws Exception {
        ParentClass parentClass = new ParentClass();

        Method parentStaticMethodParent = ReflectionHelper.getMethod(ParentClass.class, "parentStaticMethod");
        Object parentStaticMethodParentValue = parentStaticMethodParent.invoke(null);
        Assertions.assertThat(parentStaticMethodParentValue).isEqualTo("parentStaticMethod");

        Method parentMethodParent = ReflectionHelper.getMethod(ParentClass.class, "parentMethod");
        Object parentMethodParentValue = parentMethodParent.invoke(parentClass);
        Assertions.assertThat(parentMethodParentValue).isEqualTo("parentMethod");

        ChildClass childClass = new ChildClass();

        Method parentStaticMethodChild = ReflectionHelper.getMethod(ChildClass.class, "parentStaticMethod");
        Object parentStaticMethodChildValue = parentStaticMethodChild.invoke(null);
        Assertions.assertThat(parentStaticMethodChildValue).isEqualTo("parentStaticMethod");

        Method childStaticMethodChild = ReflectionHelper.getMethod(ChildClass.class, "childStaticMethod", String.class);
        Object childStaticMethodChildValue = childStaticMethodChild.invoke(null, "param");
        Assertions.assertThat(childStaticMethodChildValue).isEqualTo("childStaticMethod:param");

        Method parentMethodChild = ReflectionHelper.getMethod(ChildClass.class, "parentMethod");
        Object parentMethodChildValue = parentMethodChild.invoke(childClass);
        Assertions.assertThat(parentMethodChildValue).isEqualTo("parentMethod");

        Method childMethodChild = ReflectionHelper.getMethod(ChildClass.class, "childMethod", String.class);
        Object childMethodChildValue = childMethodChild.invoke(childClass, "param");
        Assertions.assertThat(childMethodChildValue).isEqualTo("childMethod:param");
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getMethodWrongNameFailTest() throws Exception {
        try {
            ReflectionHelper.getMethod(new ChildClass(), "wrongMethodName");
            Assertions.fail("PrivateAccessor test fail");
        } catch (ReflectionException ex) {
            Assertions.assertThat(ex).hasCause(NoSuchMethodException.class);
        }
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void callMethodWithMethodTest() throws Exception {
        // TODO
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void callMethodWithObjectTest() throws Exception {
        // TODO
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void callMethodWithClassAndObjectTest() throws Exception {
        // TODO
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getConstructorWithClassTest() throws Exception {
        Constructor<PrivateConstructorClass> constructor = ReflectionHelper.getConstructor(PrivateConstructorClass.class);
        PrivateConstructorClass object = constructor.newInstance();
        Assertions.assertThat(object).isNotNull();
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getConstructorWrongParameterCountFailTest() throws Exception {
        try {
            ReflectionHelper.getConstructor(ChildClass.class, String.class);
            Assertions.fail("PrivateAccessor test fail");
        } catch (ReflectionException ex) {
            Assertions.assertThat(ex).hasCause(NoSuchMethodException.class);
        }
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void callConstructorWithConstructorTest() throws Exception {
        // TODO
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void callConstructorWithClassTest() throws Exception {
        // TODO
    }

    /**
     * {@link ReflectionHelper} class test.
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
        ReflectionHelper.setAccessible(field);
        Object value = field.get(parentClass);
        Assertions.assertThat(value).isEqualTo("parentField");
    }

    /**
     * {@link ReflectionHelper} class test.
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
        ReflectionHelper.setAccessible(method);
        Object value = method.invoke(parentClass);
        Assertions.assertThat(value).isEqualTo("parentMethod");
    }

    /**
     * {@link ReflectionHelper} class test.
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
        ReflectionHelper.setAccessible(constructor);
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

        private String getNullField() {
            return _nullField;
        }

        private String getParentField() {
            return _parentField;
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

        private String getChildField() {
            return _childField;
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
