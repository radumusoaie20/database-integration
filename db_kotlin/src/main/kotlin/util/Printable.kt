package com.tut.db.util

interface Printable {

    fun print(text: String?);

    fun fixedPrint(text: String?, width: Int, fillChar: Char);
}