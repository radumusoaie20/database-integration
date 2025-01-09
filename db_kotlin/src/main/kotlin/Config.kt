package com.tut.db

import java.io.FileInputStream
import java.io.IOException
import java.util.Properties

class Config {


    companion object {
        private var properties: Properties = Properties()

        init{
            try{
                FileInputStream("src/main/resources/config.properties").use {
                    inputStream -> properties.load(inputStream)
                }
            }
            catch (e: IOException){
                print(e)
            }
        }
        fun getProperty(property: String): String{
            return properties.getProperty(property)
        }
    }
}