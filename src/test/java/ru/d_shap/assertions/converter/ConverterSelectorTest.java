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
package ru.d_shap.assertions.converter;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ConverterSelector}.
 *
 * @author Dmitry Shapovalov
 */
public final class ConverterSelectorTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ConverterSelectorTest() {
        super();
    }

    /**
     * {@link ConverterSelector} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(ConverterSelector.class).hasOnePrivateConstructor();
    }

    /**
     * {@link ConverterSelector} class test.
     */
    @Test
    public void retainMinimumDistanceConvertersTest() {
        List<ClassHolder> classHolders11 = createClassHolders();
        ConverterSelector.retainMinimumDistanceConverters(classHolders11, LinkedList.class, new ClassExtractorImpl());

        List<ClassHolder> classHolders21 = createClassHolders(LinkedList.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders21, LinkedList.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders21).containsExactlyInOrder(new ClassHolder(LinkedList.class));
        List<ClassHolder> classHolders22 = createClassHolders(AbstractList.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders22, LinkedList.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders22).containsExactlyInOrder(new ClassHolder(AbstractList.class));
        List<ClassHolder> classHolders23 = createClassHolders(List.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders23, LinkedList.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders23).containsExactlyInOrder(new ClassHolder(List.class));
        List<ClassHolder> classHolders24 = createClassHolders(Collection.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders24, LinkedList.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders24).containsExactlyInOrder(new ClassHolder(Collection.class));
        List<ClassHolder> classHolders25 = createClassHolders(Iterable.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders25, LinkedList.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders25).containsExactlyInOrder(new ClassHolder(Iterable.class));
        List<ClassHolder> classHolders26 = createClassHolders(Object.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders26, LinkedList.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders26).containsExactlyInOrder(new ClassHolder(Object.class));
        List<ClassHolder> classHolders27 = createClassHolders(ArrayList.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders27, LinkedList.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders27).containsExactlyInOrder();

        List<ClassHolder> classHolders31 = createClassHolders(AbstractList.class, Queue.class, Collection.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders31, LinkedList.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders31).containsExactlyInOrder(new ClassHolder(AbstractList.class), new ClassHolder(Queue.class), new ClassHolder(Collection.class));
        List<ClassHolder> classHolders32 = createClassHolders(AbstractCollection.class, AbstractList.class, Iterable.class, Queue.class, Collection.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders32, LinkedList.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders32).containsExactlyInOrder(new ClassHolder(AbstractList.class), new ClassHolder(Queue.class), new ClassHolder(Collection.class));
        List<ClassHolder> classHolders33 = createClassHolders(AbstractList.class, Queue.class, AbstractCollection.class, Iterable.class, Collection.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders33, LinkedList.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders33).containsExactlyInOrder(new ClassHolder(AbstractList.class), new ClassHolder(Queue.class), new ClassHolder(Collection.class));
        List<ClassHolder> classHolders34 = createClassHolders(AbstractList.class, Queue.class, AbstractCollection.class, Collection.class, Iterable.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders34, LinkedList.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders34).containsExactlyInOrder(new ClassHolder(AbstractList.class), new ClassHolder(Queue.class), new ClassHolder(Collection.class));
        List<ClassHolder> classHolders35 = createClassHolders(AbstractList.class, Queue.class, Object.class, Collection.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders35, LinkedList.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders35).containsExactlyInOrder(new ClassHolder(AbstractList.class), new ClassHolder(Queue.class), new ClassHolder(Collection.class));
        List<ClassHolder> classHolders36 = createClassHolders(AbstractList.class, Queue.class, AbstractSequentialList.class, Collection.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders36, LinkedList.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders36).containsExactlyInOrder(new ClassHolder(AbstractSequentialList.class));

        List<ClassHolder> classHolders41 = createClassHolders(AbstractList.class, Queue.class, Collection.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders41, HashMap.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders41).containsExactlyInOrder();
        List<ClassHolder> classHolders42 = createClassHolders(AbstractList.class, Queue.class, Collection.class);
        ConverterSelector.retainMinimumDistanceConverters(classHolders42, TreeMap.class, new ClassExtractorImpl());
        Assertions.assertThat(classHolders42).containsExactlyInOrder();
    }

    /**
     * {@link ConverterSelector} class test.
     */
    @Test(expected = NullPointerException.class)
    public void retainMinimumDistanceConvertersNullFailTest() {
        ConverterSelector.retainMinimumDistanceConverters(null, Object.class, new ClassExtractorImpl());
    }

    /**
     * {@link ConverterSelector} class test.
     */
    @Test
    public void getDistanceTest() {
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList.class, LinkedList.class)).isEqualTo(0);

        Assertions.assertThat(ConverterSelector.getDistance(LinkedList.class, AbstractSequentialList.class)).isEqualTo(1);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList.class, AbstractList.class)).isEqualTo(2);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList.class, AbstractCollection.class)).isEqualTo(3);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList.class, List.class)).isEqualTo(1);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList.class, Deque.class)).isEqualTo(1);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList.class, Queue.class)).isEqualTo(2);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList.class, Serializable.class)).isEqualTo(1);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList.class, Collection.class)).isEqualTo(2);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList.class, Iterable.class)).isEqualTo(3);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList.class, Object.class)).isEqualTo(4);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList.class, ArrayList.class)).isLessThan(0);

        Assertions.assertThat(ConverterSelector.getDistance(AbstractSequentialList.class, LinkedList.class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(AbstractList.class, LinkedList.class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(AbstractCollection.class, LinkedList.class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(List.class, LinkedList.class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Deque.class, LinkedList.class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Queue.class, LinkedList.class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Serializable.class, LinkedList.class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Collection.class, LinkedList.class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Iterable.class, LinkedList.class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Object.class, LinkedList.class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(ArrayList.class, LinkedList.class)).isLessThan(0);

        Assertions.assertThat(ConverterSelector.getDistance(List.class, List.class)).isEqualTo(0);
        Assertions.assertThat(ConverterSelector.getDistance(List.class, Collection.class)).isEqualTo(1);
        Assertions.assertThat(ConverterSelector.getDistance(List.class, Iterable.class)).isEqualTo(2);
        Assertions.assertThat(ConverterSelector.getDistance(List.class, Object.class)).isEqualTo(3);

        Assertions.assertThat(ConverterSelector.getDistance(LinkedList[].class, LinkedList[].class)).isEqualTo(0);

        Assertions.assertThat(ConverterSelector.getDistance(LinkedList[].class, AbstractSequentialList[].class)).isEqualTo(1);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList[].class, AbstractList[].class)).isEqualTo(2);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList[].class, AbstractCollection[].class)).isEqualTo(3);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList[].class, List[].class)).isEqualTo(1);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList[].class, Deque[].class)).isEqualTo(1);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList[].class, Queue[].class)).isEqualTo(2);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList[].class, Serializable[].class)).isEqualTo(1);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList[].class, Collection[].class)).isEqualTo(2);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList[].class, Iterable[].class)).isEqualTo(3);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList[].class, Object[].class)).isEqualTo(4);
        Assertions.assertThat(ConverterSelector.getDistance(LinkedList[].class, ArrayList[].class)).isLessThan(0);

        Assertions.assertThat(ConverterSelector.getDistance(AbstractSequentialList[].class, LinkedList[].class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(AbstractList[].class, LinkedList[].class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(AbstractCollection[].class, LinkedList[].class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(List[].class, LinkedList[].class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Deque[].class, LinkedList[].class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Queue[].class, LinkedList[].class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Serializable[].class, LinkedList[].class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Collection[].class, LinkedList[].class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Iterable[].class, LinkedList[].class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Object[].class, LinkedList[].class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(ArrayList[].class, LinkedList[].class)).isLessThan(0);

        Assertions.assertThat(ConverterSelector.getDistance(List[].class, List[].class)).isEqualTo(0);
        Assertions.assertThat(ConverterSelector.getDistance(List[].class, Collection[].class)).isEqualTo(1);
        Assertions.assertThat(ConverterSelector.getDistance(List[].class, Iterable[].class)).isEqualTo(2);
        Assertions.assertThat(ConverterSelector.getDistance(List[].class, Object[].class)).isEqualTo(3);

        Assertions.assertThat(ConverterSelector.getDistance(List[].class, LinkedList.class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(List[].class, List.class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(List[].class, Collection.class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(List[].class, Object.class)).isEqualTo(1);

        Assertions.assertThat(ConverterSelector.getDistance(LinkedList.class, List[].class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(List.class, List[].class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Collection.class, List[].class)).isLessThan(0);
        Assertions.assertThat(ConverterSelector.getDistance(Object.class, List[].class)).isLessThan(0);
    }

    /**
     * {@link ConverterSelector} class test.
     */
    @Test(expected = NullPointerException.class)
    public void getDistanceNullClassFailTest() {
        ConverterSelector.getDistance(null, LinkedList[].class);
    }

    /**
     * {@link ConverterSelector} class test.
     */
    @Test(expected = NullPointerException.class)
    public void getDistanceNullTargetClazzFailTest() {
        ConverterSelector.getDistance(LinkedList[].class, null);
    }

    /**
     * {@link ConverterSelector} class test.
     */
    @Test
    public void selectConverterTest() {
        // TODO
    }

    private static List<ClassHolder> createClassHolders(final Class<?>... clazzes) {
        List<ClassHolder> result = new ArrayList<>(clazzes.length);
        for (Class<?> clazz : clazzes) {
            ClassHolder classHolder = new ClassHolder(clazz);
            result.add(classHolder);
        }
        return result;
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ClassHolder {

        private final Class<?> _clazz;

        ClassHolder(final Class<?> clazz) {
            super();
            _clazz = clazz;
        }

        Class<?> getClazz() {
            return _clazz;
        }

        @Override
        public boolean equals(final Object object) {
            if (object == null) {
                return false;
            }
            if (this == object) {
                return true;
            }
            if (!(object instanceof ClassHolder)) {
                return false;
            }
            return _clazz.equals(((ClassHolder) object)._clazz);
        }

        @Override
        public int hashCode() {
            return _clazz.hashCode();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ClassExtractorImpl implements ConverterSelector.ClassExtractor<ClassHolder> {

        ClassExtractorImpl() {
            super();
        }

        @Override
        public Class<?> extractClass(final ClassHolder object) {
            return object.getClazz();
        }

    }

}
