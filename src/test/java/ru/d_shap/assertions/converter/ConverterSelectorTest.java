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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        // TODO
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

}
