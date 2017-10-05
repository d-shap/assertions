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
package ru.d_shap.assertions.collection;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link IteratorCollector}.
 *
 * @author Dmitry Shapovalov
 */
public final class IteratorCollectorTest {

    /**
     * Test class constructor.
     */
    public IteratorCollectorTest() {
        super();
    }

    /**
     * {@link IteratorCollector} class test.
     */
    @Test
    public void getAsFullListTest() {
        Iterator<String> iterator1 = Arrays.asList("a", "b", "c").iterator();
        Assertions.assertThat(new IteratorCollector<>(iterator1).getAsList()).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(new IteratorCollector<>(iterator1).getAsList()).containsExactlyInOrder();

        Iterator<String> iterator2 = Arrays.asList("a", "b", "c").iterator();
        iterator2.next();
        Assertions.assertThat(new IteratorCollector<>(iterator2).getAsList()).containsExactlyInOrder("b", "c");
        Assertions.assertThat(new IteratorCollector<>(iterator2).getAsList()).containsExactlyInOrder();

        Iterator<String> iterator3 = Arrays.asList("a", "b", "c").iterator();
        iterator3.next();
        iterator3.next();
        Assertions.assertThat(new IteratorCollector<>(iterator3).getAsList()).containsExactlyInOrder("c");
        Assertions.assertThat(new IteratorCollector<>(iterator3).getAsList()).containsExactlyInOrder();

        Iterator<String> iterator4 = Arrays.asList("a", "b", "c").iterator();
        iterator4.next();
        iterator4.next();
        iterator4.next();
        Assertions.assertThat(new IteratorCollector<>(iterator4).getAsList()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorCollector<>(iterator4).getAsList()).containsExactlyInOrder();

        IteratorCollector<String> iteratorCollector1 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector1.getAsList()).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(iteratorCollector1.getAsList()).containsExactlyInOrder("a", "b", "c");

        IteratorCollector<String> iteratorCollector2 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector2.getAsList(4)).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(iteratorCollector2.getAsList()).containsExactlyInOrder("a", "b", "c");

        IteratorCollector<String> iteratorCollector3 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector3.getAsList(3)).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(iteratorCollector3.getAsList()).containsExactlyInOrder("a", "b", "c");

        IteratorCollector<String> iteratorCollector4 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector4.getAsList(2)).containsExactlyInOrder("a", "b");
        Assertions.assertThat(iteratorCollector4.getAsList()).containsExactlyInOrder("a", "b", "c");

        IteratorCollector<String> iteratorCollector5 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector5.getAsList(1)).containsExactlyInOrder("a");
        Assertions.assertThat(iteratorCollector5.getAsList()).containsExactlyInOrder("a", "b", "c");

        IteratorCollector<String> iteratorCollector6 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector6.getAsList(0)).containsExactlyInOrder();
        Assertions.assertThat(iteratorCollector6.getAsList()).containsExactlyInOrder("a", "b", "c");
    }

    /**
     * {@link IteratorCollector} class test.
     */
    @Test
    public void getAsListWithSizeTest() {
        Iterator<String> iterator1 = Arrays.asList("a", "b", "c").iterator();
        Assertions.assertThat(new IteratorCollector<>(iterator1).getAsList(4)).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(new IteratorCollector<>(iterator1).getAsList(4)).containsExactlyInOrder();
        Assertions.assertThat(new IteratorCollector<>(iterator1).getAsList(4)).containsExactlyInOrder();
        Assertions.assertThat(new IteratorCollector<>(iterator1).getAsList(4)).containsExactlyInOrder();

        Iterator<String> iterator2 = Arrays.asList("a", "b", "c").iterator();
        Assertions.assertThat(new IteratorCollector<>(iterator2).getAsList(3)).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(new IteratorCollector<>(iterator2).getAsList(3)).containsExactlyInOrder();
        Assertions.assertThat(new IteratorCollector<>(iterator2).getAsList(3)).containsExactlyInOrder();
        Assertions.assertThat(new IteratorCollector<>(iterator2).getAsList(3)).containsExactlyInOrder();

        Iterator<String> iterator3 = Arrays.asList("a", "b", "c").iterator();
        Assertions.assertThat(new IteratorCollector<>(iterator3).getAsList(2)).containsExactlyInOrder("a", "b");
        Assertions.assertThat(new IteratorCollector<>(iterator3).getAsList(2)).containsExactlyInOrder("c");
        Assertions.assertThat(new IteratorCollector<>(iterator3).getAsList(2)).containsExactlyInOrder();
        Assertions.assertThat(new IteratorCollector<>(iterator3).getAsList(2)).containsExactlyInOrder();

        Iterator<String> iterator4 = Arrays.asList("a", "b", "c").iterator();
        Assertions.assertThat(new IteratorCollector<>(iterator4).getAsList(1)).containsExactlyInOrder("a");
        Assertions.assertThat(new IteratorCollector<>(iterator4).getAsList(1)).containsExactlyInOrder("b");
        Assertions.assertThat(new IteratorCollector<>(iterator4).getAsList(1)).containsExactlyInOrder("c");
        Assertions.assertThat(new IteratorCollector<>(iterator4).getAsList(1)).containsExactlyInOrder();

        Iterator<String> iterator5 = Arrays.asList("a", "b", "c").iterator();
        Assertions.assertThat(new IteratorCollector<>(iterator5).getAsList(0)).containsExactlyInOrder();
        Assertions.assertThat(new IteratorCollector<>(iterator5).getAsList(0)).containsExactlyInOrder();
        Assertions.assertThat(new IteratorCollector<>(iterator5).getAsList(0)).containsExactlyInOrder();
        Assertions.assertThat(new IteratorCollector<>(iterator5).getAsList(0)).containsExactlyInOrder();
        Assertions.assertThat(new IteratorCollector<>(iterator5).getAsList(5)).containsExactlyInOrder("a", "b", "c");

        IteratorCollector<String> iteratorCollector1 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector1.getAsList(4)).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(iteratorCollector1.getAsList(4)).containsExactlyInOrder();
        Assertions.assertThat(iteratorCollector1.getAsList(4)).containsExactlyInOrder();
        Assertions.assertThat(iteratorCollector1.getAsList(4)).containsExactlyInOrder();

        IteratorCollector<String> iteratorCollector2 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector2.getAsList(3)).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(iteratorCollector2.getAsList(3)).containsExactlyInOrder();
        Assertions.assertThat(iteratorCollector2.getAsList(3)).containsExactlyInOrder();
        Assertions.assertThat(iteratorCollector2.getAsList(3)).containsExactlyInOrder();

        IteratorCollector<String> iteratorCollector3 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector3.getAsList(2)).containsExactlyInOrder("a", "b");
        Assertions.assertThat(iteratorCollector3.getAsList(2)).containsExactlyInOrder("c");
        Assertions.assertThat(iteratorCollector3.getAsList(2)).containsExactlyInOrder();
        Assertions.assertThat(iteratorCollector3.getAsList(2)).containsExactlyInOrder();

        IteratorCollector<String> iteratorCollector4 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector4.getAsList(1)).containsExactlyInOrder("a");
        Assertions.assertThat(iteratorCollector4.getAsList(1)).containsExactlyInOrder("b");
        Assertions.assertThat(iteratorCollector4.getAsList(1)).containsExactlyInOrder("c");
        Assertions.assertThat(iteratorCollector4.getAsList(1)).containsExactlyInOrder();

        IteratorCollector<String> iteratorCollector5 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector5.getAsList(0)).containsExactlyInOrder();
        Assertions.assertThat(iteratorCollector5.getAsList(0)).containsExactlyInOrder();
        Assertions.assertThat(iteratorCollector5.getAsList(0)).containsExactlyInOrder();
        Assertions.assertThat(iteratorCollector5.getAsList(0)).containsExactlyInOrder();
        Assertions.assertThat(iteratorCollector5.getAsList(5)).containsExactlyInOrder("a", "b", "c");
    }

    /**
     * {@link IteratorCollector} class test.
     */
    @Test
    public void toStringTest() {
        IteratorCollector<String> iteratorCollector1 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector1.toString()).isEqualTo("[a, b, c]");
        Assertions.assertThat(iteratorCollector1.toString()).isEqualTo("[a, b, c]");

        IteratorCollector<String> iteratorCollector2 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector2.getAsList()).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(iteratorCollector2.toString()).isEqualTo("[a, b, c]");
        Assertions.assertThat(iteratorCollector2.toString()).isEqualTo("[a, b, c]");
        Assertions.assertThat(iteratorCollector2.getAsList()).containsExactlyInOrder("a", "b", "c");

        IteratorCollector<String> iteratorCollector3 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector3.getAsList(4)).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(iteratorCollector3.toString()).isEqualTo("[a, b, c]");
        Assertions.assertThat(iteratorCollector3.toString()).isEqualTo("[a, b, c]");
        Assertions.assertThat(iteratorCollector3.getAsList()).containsExactlyInOrder("a", "b", "c");

        IteratorCollector<String> iteratorCollector4 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector4.getAsList(3)).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(iteratorCollector4.toString()).isEqualTo("[a, b, c]");
        Assertions.assertThat(iteratorCollector4.toString()).isEqualTo("[a, b, c]");
        Assertions.assertThat(iteratorCollector4.getAsList()).containsExactlyInOrder("a", "b", "c");

        IteratorCollector<String> iteratorCollector5 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector5.getAsList(2)).containsExactlyInOrder("a", "b");
        Assertions.assertThat(iteratorCollector5.toString()).isEqualTo("[a, b, c]");
        Assertions.assertThat(iteratorCollector5.toString()).isEqualTo("[a, b, c]");
        Assertions.assertThat(iteratorCollector5.getAsList()).containsExactlyInOrder("a", "b", "c");

        IteratorCollector<String> iteratorCollector6 = new IteratorCollector<>(Arrays.asList("a", "b", "c").iterator());
        Assertions.assertThat(iteratorCollector6.getAsList(1)).containsExactlyInOrder("a");
        Assertions.assertThat(iteratorCollector6.toString()).isEqualTo("[a, b, c]");
        Assertions.assertThat(iteratorCollector6.toString()).isEqualTo("[a, b, c]");
        Assertions.assertThat(iteratorCollector6.getAsList()).containsExactlyInOrder("a", "b", "c");
    }

}
