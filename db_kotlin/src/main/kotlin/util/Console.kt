package com.tut.db.util

class Console : Printable {
    override fun print(text: String?) {
        kotlin.io.print(text)
    }

    override fun fixedPrint(text: String?, width: Int, fillChar: Char) {
        val l = text?.length ?: 0;
        if (l > width){
            kotlin.io.print(text?.substring(0, width))
        }
        else{
            val remaining = width - l;
            kotlin.io.print(text)
            for(i in 1..remaining)
                kotlin.io.print(fillChar)
        }
    }

}