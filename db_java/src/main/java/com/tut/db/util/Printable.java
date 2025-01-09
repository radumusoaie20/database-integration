package com.tut.db.util;

public interface Printable {

    void print(String text);


    /** Note, this method will truncate the input in case it's length is bigger than the width
     *
     * @param text The text input to be printed
     * @param width The width of the printed output ( the total number of printed characters)
     * @param fillCharacter The character to fill in case the output is less than the width
     */
    void fixedPrint(String text, int width, Character fillCharacter);
}
