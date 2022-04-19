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

/**
 * Class to hold a hex representation of numbers.
 *
 * @author Dmitry Shapovalov
 */
public final class HexString implements CharSequence {

    private static final String[] HEX_VALUES;

    static {
        HEX_VALUES = new String[16];
        HEX_VALUES[0] = "0";
        HEX_VALUES[1] = "1";
        HEX_VALUES[2] = "2";
        HEX_VALUES[3] = "3";
        HEX_VALUES[4] = "4";
        HEX_VALUES[5] = "5";
        HEX_VALUES[6] = "6";
        HEX_VALUES[7] = "7";
        HEX_VALUES[8] = "8";
        HEX_VALUES[9] = "9";
        HEX_VALUES[10] = "a";
        HEX_VALUES[11] = "b";
        HEX_VALUES[12] = "c";
        HEX_VALUES[13] = "d";
        HEX_VALUES[14] = "e";
        HEX_VALUES[15] = "f";
    }

    private String _value;

    /**
     * Create new object.
     */
    public HexString() {
        super();
        _value = "";
    }

    /**
     * Add the specified byte value to the hex string.
     *
     * @param value the specified byte value.
     */
    public void addValue(final byte value) {
        byte part1 = (byte) (value >> 4 & 0xF);
        String str1 = HEX_VALUES[part1];
        byte part2 = (byte) (value & 0xF);
        String str2 = HEX_VALUES[part2];
        _value += str1 + str2;
    }

    /**
     * Add the specified short value to the hex string.
     *
     * @param value the specified short value.
     */
    public void addValue(final short value) {
        byte part1 = (byte) (value >> 8);
        addValue(part1);
        byte part2 = (byte) value;
        addValue(part2);
    }

    /**
     * Add the specified int value to the hex string.
     *
     * @param value the specified int value.
     */
    public void addValue(final int value) {
        byte part1 = (byte) (value >> 24);
        addValue(part1);
        byte part2 = (byte) (value >> 16);
        addValue(part2);
        byte part3 = (byte) (value >> 8);
        addValue(part3);
        byte part4 = (byte) value;
        addValue(part4);
    }

    /**
     * Add the specified long value to the hex string.
     *
     * @param value the specified long value.
     */
    public void addValue(final long value) {
        byte part1 = (byte) (value >> 56);
        addValue(part1);
        byte part2 = (byte) (value >> 48);
        addValue(part2);
        byte part3 = (byte) (value >> 40);
        addValue(part3);
        byte part4 = (byte) (value >> 32);
        addValue(part4);
        byte part5 = (byte) (value >> 24);
        addValue(part5);
        byte part6 = (byte) (value >> 16);
        addValue(part6);
        byte part7 = (byte) (value >> 8);
        addValue(part7);
        byte part8 = (byte) value;
        addValue(part8);
    }

    @Override
    public int length() {
        return _value.length();
    }

    @Override
    public char charAt(final int index) {
        return _value.charAt(index);
    }

    @Override
    public CharSequence subSequence(final int from, final int to) {
        return _value.subSequence(from, to);
    }

    @Override
    public String toString() {
        return _value;
    }

}
