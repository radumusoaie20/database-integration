# Database integration

Welcome! In here you will find simple examples of connecting to a database using various programming languages!

The programming languages used are: `Java`, `Python`, `Kotlin`, `Typescript`.

We connected to a database and run a simple query that selects a table and then displays the query result in the console.

In order to use this, I will give you some help on how to approach with each language: 

1. Java and Kotlin - in order to use Java and Kotlin, I recommend using IntelliJ Idea (great support for these languages).
    * When creating the Java project, select Java SE, with Gradle and Groovy. In the `build.gradle` you will need to paste this in the `dependencies`: `implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.15'`
    * When creating the Kotlin project, select Kotlin as the language, and in the `build.gradle.kts`, you need to paste this : `dependencies {

   implementation("mysql","mysql-connector-java",  "8.0.15")
}`

2. Python - in order to use Python, I recommend using PyCharm (like the first IDE, it offers great support). Make sure you have the Python Interpreter installed! (I believe that PyCharm may install it directly)
    * When creating the Python project, the only dependency will need is this one: `python -m pip install mysql-connector-python` (run this in a terminal in the project)

3. Typescript - in order to use Typescript, I recommend using Visual Studio Code(even though I think WebStorm might be better, VS Code is simpler to use). Create a new typescript project this way(be sure to install NodeJS first, preferably the latest since some version of Typescript require some versions of Node):
    * npm init -y
    * tsc --init
    * npm install ts-node
    * npm install mysql2

You are now ready to go!