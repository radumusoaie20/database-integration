package com.tut.db.util;

public class Console implements Printable{

    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void fixedPrint(String text, int width, Character fillCharacter) {
        int l = text.length();
        if(l > width)
            System.out.print(text.substring(0, width));
        else{
            int remaining = width - l;
            System.out.print(text);
            for(int i = 0; i < remaining; i++)
                System.out.print(fillCharacter);
        }
    }
}
