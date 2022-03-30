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
package ru.d_shap.assertions.asimp;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link HexString}.
 *
 * @author Dmitry Shapovalov
 */
public final class HexStringTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public HexStringTest() {
        super();
    }

    /**
     * {@link HexString} class test.
     */
    @Test
    public void addByteValueTest() {
        HexString hexString01 = new HexString();
        hexString01.addValue((byte) 0);
        Assertions.assertThat(hexString01).hasToString("00");

        HexString hexString02 = new HexString();
        hexString02.addValue((byte) 1);
        Assertions.assertThat(hexString02).hasToString("01");

        HexString hexString03 = new HexString();
        hexString03.addValue((byte) 31);
        Assertions.assertThat(hexString03).hasToString("1f");

        HexString hexString04 = new HexString();
        hexString04.addValue((byte) 100);
        Assertions.assertThat(hexString04).hasToString("64");

        HexString hexString05 = new HexString();
        hexString05.addValue(Byte.MAX_VALUE);
        Assertions.assertThat(hexString05).hasToString("7f");

        HexString hexString06 = new HexString();
        hexString06.addValue((byte) -1);
        Assertions.assertThat(hexString06).hasToString("ff");

        HexString hexString07 = new HexString();
        hexString07.addValue((byte) -100);
        Assertions.assertThat(hexString07).hasToString("9c");

        HexString hexString08 = new HexString();
        hexString08.addValue(Byte.MIN_VALUE);
        Assertions.assertThat(hexString08).hasToString("80");
        hexString08.addValue((byte) 44);
        Assertions.assertThat(hexString08).hasToString("802c");
        hexString08.addValue((byte) -97);
        Assertions.assertThat(hexString08).hasToString("802c9f");
    }

    /**
     * {@link HexString} class test.
     */
    @Test
    public void addShortValueTest() {
        HexString hexString01 = new HexString();
        hexString01.addValue((short) 0);
        Assertions.assertThat(hexString01).hasToString("0000");

        HexString hexString02 = new HexString();
        hexString02.addValue((short) 1);
        Assertions.assertThat(hexString02).hasToString("0001");

        HexString hexString03 = new HexString();
        hexString03.addValue((short) 31);
        Assertions.assertThat(hexString03).hasToString("001f");

        HexString hexString04 = new HexString();
        hexString04.addValue((short) 479);
        Assertions.assertThat(hexString04).hasToString("01df");

        HexString hexString05 = new HexString();
        hexString05.addValue((short) 7311);
        Assertions.assertThat(hexString05).hasToString("1c8f");

        HexString hexString06 = new HexString();
        hexString06.addValue(Short.MAX_VALUE);
        Assertions.assertThat(hexString06).hasToString("7fff");

        HexString hexString07 = new HexString();
        hexString07.addValue((short) -1);
        Assertions.assertThat(hexString07).hasToString("ffff");

        HexString hexString08 = new HexString();
        hexString08.addValue((short) -100);
        Assertions.assertThat(hexString08).hasToString("ff9c");

        HexString hexString09 = new HexString();
        hexString09.addValue(Short.MIN_VALUE);
        Assertions.assertThat(hexString09).hasToString("8000");
        hexString09.addValue((short) 10347);
        Assertions.assertThat(hexString09).hasToString("8000286b");
        hexString09.addValue((short) -22978);
        Assertions.assertThat(hexString09).hasToString("8000286ba63e");
    }

    /**
     * {@link HexString} class test.
     */
    @Test
    public void addIntegerValueTest() {
        // TODO
    }

    /**
     * {@link HexString} class test.
     */
    @Test
    public void addLongValueTest() {
        // TODO
    }

}
