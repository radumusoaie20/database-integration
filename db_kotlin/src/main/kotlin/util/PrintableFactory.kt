package com.tut.db.util

class PrintableFactory {
  companion object {
      fun getPrintable(): Printable {
          return Console();
      }
  }
}