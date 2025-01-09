package com.tut.db
import com.tut.db.util.PrintableFactory
import java.sql.DriverManager
import java.sql.ResultSet

fun main() {

    // Used for printing
    val printable = PrintableFactory.getPrintable()
    // JDBC url of form: jdbc:mysql://[SERVER]:[PORT]/[DATABASE]
    // The JVM for Kotlin is configured to use SSL by default, so we can use ?useSSL=false
    val url = "jdbc:mysql://localhost:3306/universitate?useSSL=false"
    val username = Config.getProperty("MYSQL_USERNAME")
    val password = Config.getProperty("MYSQL_PASSWORD")

    try{
        // Get database connection using the DriverManager
        val connection = DriverManager.getConnection(url, username, password)
        // Example query
        val statement = connection.createStatement()
        val result = statement.executeQuery("SELECT * FROM student")

        //  Access column definitions to get the number of columns
        val databaseMetadata = result.metaData
        val columnCount = databaseMetadata.columnCount
        val width = 17

        // Print table headings with a fixed column width
        for(i in 1..columnCount){
            val columnLabel = databaseMetadata.getColumnLabel(i)
            printable.fixedPrint(columnLabel, width, ' ')
        }
        printable.print("\n")
        printable.fixedPrint("", width*columnCount, '-')
        printable.print("\n")

        // Print the query results with a fixed column width
        while(result.next()){
            for(i in 1..columnCount){
                 val columnValue = result.getString(i)
                 printable.fixedPrint(columnValue, width, ' ')
            }
            printable.print("\n")
        }
        // Close the connection
        connection.close()
    }
    catch (e: Exception){
        printable.print(e.message)
    }

}