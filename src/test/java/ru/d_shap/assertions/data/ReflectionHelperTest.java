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
import java.lang.reflect.InvocationTargetException;
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
     */
    @Test
    public void getFieldWrongNameFailTest() {
        try {
            ReflectionHelper.getField(new ChildClass(), "wrongFieldName");
            Assertions.fail("PrivateAccessor test fail");
        } catch (ReflectionException ex) {
            Assertions.assertThat(ex).hasMessage("wrongFieldName");
            Assertions.assertThat(ex).hasCause(NoSuchFieldException.class);
        }
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void getFieldValueWithFieldTest() {
        ParentClass parentClass = new ParentClass();

        Field nullStaticFieldParent = ReflectionHelper.getField(ParentClass.class, "NULL_STATIC_FIELD");
        Object nullStaticFieldParentValue = ReflectionHelper.getFieldValue(nullStaticFieldParent, (Object) null);
        Assertions.assertThat(nullStaticFieldParentValue).isNull();

        Field parentStaticFieldParent = ReflectionHelper.getField(ParentClass.class, "PARENT_STATIC_FIELD");
        Object parentStaticFieldParentValue = ReflectionHelper.getFieldValue(parentStaticFieldParent, (Object) null);
        Assertions.assertThat(parentStaticFieldParentValue).isEqualTo("parentStaticField");

        Field nullFieldParent = ReflectionHelper.getField(ParentClass.class, "_nullField");
        Object nullFieldParentValue = ReflectionHelper.getFieldValue(nullFieldParent, parentClass);
        Assertions.assertThat(nullFieldParentValue).isNull();

        Field parentFieldParent = ReflectionHelper.getField(ParentClass.class, "_parentField");
        Object parentFieldParentValue = ReflectionHelper.getFieldValue(parentFieldParent, parentClass);
        Assertions.assertThat(parentFieldParentValue).isEqualTo("parentField");

        ChildClass childClass = new ChildClass();

        Field nullStaticFieldChild = ReflectionHelper.getField(ChildClass.class, "NULL_STATIC_FIELD");
        Object nullStaticFieldChildValue = ReflectionHelper.getFieldValue(nullStaticFieldChild, (Object) null);
        Assertions.assertThat(nullStaticFieldChildValue).isNull();

        Field parentStaticFieldChild = ReflectionHelper.getField(ChildClass.class, "PARENT_STATIC_FIELD");
        Object parentStaticFieldChildValue = ReflectionHelper.getFieldValue(parentStaticFieldChild, (Object) null);
        Assertions.assertThat(parentStaticFieldChildValue).isEqualTo("parentStaticField");

        Field childStaticFieldChild = ReflectionHelper.getField(ChildClass.class, "CHILD_STATIC_FIELD");
        Object childStaticFieldChildValue = ReflectionHelper.getFieldValue(childStaticFieldChild, (Object) null);
        Assertions.assertThat(childStaticFieldChildValue).isEqualTo("childStaticField");

        Field nullFieldChild = ReflectionHelper.getField(ChildClass.class, "_nullField");
        Object nullFieldChildValue = ReflectionHelper.getFieldValue(nullFieldChild, childClass);
        Assertions.assertThat(nullFieldChildValue).isNull();

        Field parentFieldChild = ReflectionHelper.getField(ChildClass.class, "_parentField");
        Object parentFieldChildValue = ReflectionHelper.getFieldValue(parentFieldChild, childClass);
        Assertions.assertThat(parentFieldChildValue).isEqualTo("parentField");

        Field childField = ReflectionHelper.getField(ChildClass.class, "_childField");
        Object childFieldValue = ReflectionHelper.getFieldValue(childField, childClass);
        Assertions.assertThat(childFieldValue).isEqualTo("childField");
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void getFieldValueWithFieldNoAccessFailTest() {
        try {
            Field field = ReflectionHelper.getField(ChildClass.class, "_childField");
            field.setAccessible(false);
            ReflectionHelper.getFieldValue(field, new ChildClass());
            Assertions.fail("PrivateAccessor test fail");
        } catch (ReflectionException ex) {
            Assertions.assertThat(ex).messageMatches("Class .* can not access a member of class .* with modifiers \"private final\"");
            Assertions.assertThat(ex).hasCause(IllegalAccessException.class);
        }
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void getFieldValueWithObjectTest() {
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
     */
    @Test
    public void getFieldValueWithClassTest() {
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

        Method childMethod1Child = ReflectionHelper.getMethod(childClass, "childMethod", String.class);
        Object childMethod1ChildValue = childMethod1Child.invoke(childClass, "param");
        Assertions.assertThat(childMethod1ChildValue).isEqualTo("childMethod:param");

        Method childMethod2Child = ReflectionHelper.getMethod(childClass, "childMethod", String.class, int.class);
        Object childMethod2ChildValue = childMethod2Child.invoke(childClass, "param", 5);
        Assertions.assertThat(childMethod2ChildValue).isEqualTo("childMethod:param,5");
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

        Method childMethod1Child = ReflectionHelper.getMethod(ChildClass.class, "childMethod", String.class);
        Object childMethod1ChildValue = childMethod1Child.invoke(childClass, "param");
        Assertions.assertThat(childMethod1ChildValue).isEqualTo("childMethod:param");

        Method childMethod2Child = ReflectionHelper.getMethod(ChildClass.class, "childMethod", String.class, int.class);
        Object childMethod2ChildValue = childMethod2Child.invoke(childClass, "param", 5);
        Assertions.assertThat(childMethod2ChildValue).isEqualTo("childMethod:param,5");
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void getMethodWrongNameFailTest() {
        try {
            ReflectionHelper.getMethod(new ChildClass(), "wrongMethodName");
            Assertions.fail("PrivateAccessor test fail");
        } catch (ReflectionException ex) {
            Assertions.assertThat(ex).hasCause(NoSuchMethodException.class);
        }
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void callMethodWithMethodTest() {
        ParentClass parentClass = new ParentClass();

        Method parentStaticMethodParent = ReflectionHelper.getMethod(ParentClass.class, "parentStaticMethod");
        Object parentStaticMethodParentValue = ReflectionHelper.callMethod(parentStaticMethodParent, (Object) null);
        Assertions.assertThat(parentStaticMethodParentValue).isEqualTo("parentStaticMethod");

        Method parentMethodParent = ReflectionHelper.getMethod(ParentClass.class, "parentMethod");
        Object parentMethodParentValue = ReflectionHelper.callMethod(parentMethodParent, parentClass);
        Assertions.assertThat(parentMethodParentValue).isEqualTo("parentMethod");

        ChildClass childClass = new ChildClass();

        Method parentStaticMethodChild = ReflectionHelper.getMethod(ChildClass.class, "parentStaticMethod");
        Object parentStaticMethodChildValue = ReflectionHelper.callMethod(parentStaticMethodChild, (Object) null);
        Assertions.assertThat(parentStaticMethodChildValue).isEqualTo("parentStaticMethod");

        Method childStaticMethodChild = ReflectionHelper.getMethod(ChildClass.class, "childStaticMethod", String.class);
        Object childStaticMethodChildValue = ReflectionHelper.callMethod(childStaticMethodChild, (Object) null, "param");
        Assertions.assertThat(childStaticMethodChildValue).isEqualTo("childStaticMethod:param");

        Method parentMethodChild = ReflectionHelper.getMethod(ChildClass.class, "parentMethod");
        Object parentMethodChildValue = ReflectionHelper.callMethod(parentMethodChild, childClass);
        Assertions.assertThat(parentMethodChildValue).isEqualTo("parentMethod");

        Method childMethod1Child = ReflectionHelper.getMethod(ChildClass.class, "childMethod", String.class);
        Object childMethod1ChildValue = ReflectionHelper.callMethod(childMethod1Child, childClass, "param");
        Assertions.assertThat(childMethod1ChildValue).isEqualTo("childMethod:param");

        Method childMethod2Child = ReflectionHelper.getMethod(ChildClass.class, "childMethod", String.class, int.class);
        Object childMethod2ChildValue = ReflectionHelper.callMethod(childMethod2Child, childClass, "param", 5);
        Assertions.assertThat(childMethod2ChildValue).isEqualTo("childMethod:param,5");
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void callMethodWithMethodNoAccessFailTest() {
        try {
            Method method = ReflectionHelper.getMethod(ChildClass.class, "childMethod", String.class);
            method.setAccessible(false);
            ReflectionHelper.callMethod(method, new ChildClass(), "param");
            Assertions.fail("PrivateAccessor test fail");
        } catch (ReflectionException ex) {
            Assertions.assertThat(ex).messageMatches("Class .* can not access a member of class .* with modifiers \"private\"");
            Assertions.assertThat(ex).hasCause(IllegalAccessException.class);
        }
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void callMethodWithMethodInvocationFailTest() {
        try {
            Method method = ReflectionHelper.getMethod(ChildClass.class, "childFailMethod");
            ReflectionHelper.callMethod(method, new ChildClass());
            Assertions.fail("PrivateAccessor test fail");
        } catch (ReflectionException ex) {
            Assertions.assertThat(ex).toMessage().isNull();
            Assertions.assertThat(ex).hasCause(InvocationTargetException.class);
        }
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void callMethodWithObjectAndParameterTypesTest() {
        ParentClass parentClass = new ParentClass();

        Object parentMethodParentValue = ReflectionHelper.callMethod(parentClass, "parentMethod", new Class<?>[]{}, new Object[]{});
        Assertions.assertThat(parentMethodParentValue).isEqualTo("parentMethod");

        ChildClass childClass = new ChildClass();

        Object parentMethodChildValue = ReflectionHelper.callMethod(childClass, "parentMethod", new Class<?>[]{}, new Object[]{});
        Assertions.assertThat(parentMethodChildValue).isEqualTo("parentMethod");

        Object childMethod1ChildValue = ReflectionHelper.callMethod(childClass, "childMethod", new Class<?>[]{String.class}, new Object[]{"param"});
        Assertions.assertThat(childMethod1ChildValue).isEqualTo("childMethod:param");

        Object childMethod2ChildValue = ReflectionHelper.callMethod(childClass, "childMethod", new Class<?>[]{String.class, int.class}, new Object[]{"param", 5});
        Assertions.assertThat(childMethod2ChildValue).isEqualTo("childMethod:param,5");
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void callMethodWithObjectTest() {
        ParentClass parentClass = new ParentClass();

        Object parentMethodParentValue = ReflectionHelper.callMethod(parentClass, "parentMethod");
        Assertions.assertThat(parentMethodParentValue).isEqualTo("parentMethod");

        ChildClass childClass = new ChildClass();

        Object parentMethodChildValue = ReflectionHelper.callMethod(childClass, "parentMethod");
        Assertions.assertThat(parentMethodChildValue).isEqualTo("parentMethod");

        Object childMethodChildValue = ReflectionHelper.callMethod(childClass, "childMethod", "param");
        Assertions.assertThat(childMethodChildValue).isEqualTo("childMethod:param");

        try {
            ReflectionHelper.callMethod(childClass, "childMethod", "param", 5);
            Assertions.fail("PrivateAccessor test fail");
        } catch (ReflectionException ex) {
            Assertions.assertThat(ex).hasMessage("java.lang.Object.childMethod(java.lang.String, java.lang.Integer)");
            Assertions.assertThat(ex).hasCause(NoSuchMethodException.class);
        }
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void callMethodWithClassAndParameterTypesTest() {
        ParentClass parentClass = new ParentClass();

        Object parentStaticMethodParentValue = ReflectionHelper.callMethod(ParentClass.class, null, "parentStaticMethod", new Class<?>[]{}, new Object[]{});
        Assertions.assertThat(parentStaticMethodParentValue).isEqualTo("parentStaticMethod");

        Object parentMethodParentValue = ReflectionHelper.callMethod(ParentClass.class, parentClass, "parentMethod", new Class<?>[]{}, new Object[]{});
        Assertions.assertThat(parentMethodParentValue).isEqualTo("parentMethod");

        ChildClass childClass = new ChildClass();

        Object parentStaticMethodChildValue = ReflectionHelper.callMethod(ChildClass.class, null, "parentStaticMethod", new Class<?>[]{}, new Object[]{});
        Assertions.assertThat(parentStaticMethodChildValue).isEqualTo("parentStaticMethod");

        Object childStaticMethodChildValue = ReflectionHelper.callMethod(ChildClass.class, null, "childStaticMethod", new Class<?>[]{String.class}, new Object[]{"param"});
        Assertions.assertThat(childStaticMethodChildValue).isEqualTo("childStaticMethod:param");

        Object parentMethodChildValue = ReflectionHelper.callMethod(ChildClass.class, childClass, "parentMethod", new Class<?>[]{}, new Object[]{});
        Assertions.assertThat(parentMethodChildValue).isEqualTo("parentMethod");

        Object childMethod1ChildValue = ReflectionHelper.callMethod(ChildClass.class, childClass, "childMethod", new Class<?>[]{String.class}, new Object[]{"param"});
        Assertions.assertThat(childMethod1ChildValue).isEqualTo("childMethod:param");

        Object childMethod2ChildValue = ReflectionHelper.callMethod(ChildClass.class, childClass, "childMethod", new Class<?>[]{String.class, int.class}, new Object[]{"param", 5});
        Assertions.assertThat(childMethod2ChildValue).isEqualTo("childMethod:param,5");
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void callMethodWithClassTest() {
        ParentClass parentClass = new ParentClass();

        Object parentStaticMethodParentValue = ReflectionHelper.callMethod(ParentClass.class, (ParentClass) null, "parentStaticMethod");
        Assertions.assertThat(parentStaticMethodParentValue).isEqualTo("parentStaticMethod");

        Object parentMethodParentValue = ReflectionHelper.callMethod(ParentClass.class, parentClass, "parentMethod");
        Assertions.assertThat(parentMethodParentValue).isEqualTo("parentMethod");

        ChildClass childClass = new ChildClass();

        Object parentStaticMethodChildValue = ReflectionHelper.callMethod(ChildClass.class, (ChildClass) null, "parentStaticMethod");
        Assertions.assertThat(parentStaticMethodChildValue).isEqualTo("parentStaticMethod");

        Object childStaticMethodChildValue = ReflectionHelper.callMethod(ChildClass.class, (ChildClass) null, "childStaticMethod", "param");
        Assertions.assertThat(childStaticMethodChildValue).isEqualTo("childStaticMethod:param");

        Object parentMethodChildValue = ReflectionHelper.callMethod(ChildClass.class, childClass, "parentMethod");
        Assertions.assertThat(parentMethodChildValue).isEqualTo("parentMethod");

        Object childMethodChildValue = ReflectionHelper.callMethod(ChildClass.class, childClass, "childMethod", "param");
        Assertions.assertThat(childMethodChildValue).isEqualTo("childMethod:param");

        try {
            ReflectionHelper.callMethod(ChildClass.class, childClass, "childMethod", "param", 5);
            Assertions.fail("PrivateAccessor test fail");
        } catch (ReflectionException ex) {
            Assertions.assertThat(ex).hasMessage("java.lang.Object.childMethod(java.lang.String, java.lang.Integer)");
            Assertions.assertThat(ex).hasCause(NoSuchMethodException.class);
        }
    }

    /**
     * {@link ReflectionHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void getConstructorWithClassTest() throws Exception {
        Constructor<PrivateConstructorClass> constructor1 = ReflectionHelper.getConstructor(PrivateConstructorClass.class);
        PrivateConstructorClass object1 = constructor1.newInstance();
        Assertions.assertThat(object1.getValue()).isEqualTo("No args");

        Constructor<PrivateConstructorClass> constructor2 = ReflectionHelper.getConstructor(PrivateConstructorClass.class, String.class);
        PrivateConstructorClass object2 = constructor2.newInstance("param");
        Assertions.assertThat(object2.getValue()).isEqualTo("One arg: param");

        Constructor<PrivateConstructorClass> constructor3 = ReflectionHelper.getConstructor(PrivateConstructorClass.class, String.class, int.class);
        PrivateConstructorClass object3 = constructor3.newInstance("param", 5);
        Assertions.assertThat(object3.getValue()).isEqualTo("Two args: param,5");
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void getConstructorWrongParameterCountFailTest() {
        try {
            ReflectionHelper.getConstructor(ChildClass.class, String.class);
            Assertions.fail("PrivateAccessor test fail");
        } catch (ReflectionException ex) {
            Assertions.assertThat(ex).messageMatches(".*\\$ChildClass.<init>\\(java.lang.String\\)");
            Assertions.assertThat(ex).hasCause(NoSuchMethodException.class);
        }
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void callConstructorWithConstructorTest() {
        // TODO
    }

    /**
     * {@link ReflectionHelper} class test.
     */
    @Test
    public void callConstructorWithClassTest() {
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

        private String getNullField() {
            return _nullField;
        }

        private String getParentField() {
            return _parentField;
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

        private String getChildField() {
            return _childField;
        }

        private static String childStaticMethod(final String param) {
            return "childStaticMethod:" + param;
        }

        private String childMethod(final String param) {
            return "childMethod:" + param;
        }

        private String childMethod(final String param1, final int param2) {
            return "childMethod:" + param1 + "," + param2;
        }

        private void childFailMethod() {
            throw new RuntimeException("test exception");
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class PrivateConstructorClass {

        private final String _value;

        private PrivateConstructorClass() {
            super();
            _value = "No args";
        }

        private PrivateConstructorClass(final String param) {
            super();
            _value = "One arg: " + param;
        }

        private PrivateConstructorClass(final String param1, final int param2) {
            super();
            _value = "Two args: " + param1 + "," + param2;
        }

        String getValue() {
            return _value;
        }

    }

}
