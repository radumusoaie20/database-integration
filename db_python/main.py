# To connect to a MySQL database, you need the mysql-connector-python, install it with this command:
# python -m pip install mysql-connector-python
import mysql.connector

# Helper functions
from config import get_property
from print import fixed_print

# The username is stored in config.properties as MYSQL_USERNAME
username = get_property("MYSQL_USERNAME")

# The password is stored in config.properties as MYSQL_PASSWORD
password = get_property("MYSQL_PASSWORD")

# We need the server host (IP Address). Right now, we are on a local server(localhost)
host = "localhost"

# We need the database too
database="universitate"

# Attempt connection using the connector

university_db = mysql.connector.connect(
    host=host,
    username=username,
    password=password,
    database=database
)

# Now we can execute queries!

# Equivalent to a statement, a tool to prepare commands for the database
cursor = university_db.cursor()

# Execute the query
cursor.execute("SELECT * FROM student")

# Fetch all the results
result = cursor.fetchall()

# Use a fixed width
width=17

# Get the columns

columns = cursor.column_names

# Print the table heading with fixed width
for column in columns:
    fixed_print(column, width, " ")

print()
fixed_print("", len(columns)*width, "-")
print()
# Print the results to the console, each column with fixed width
for row in result:
    count = len(row)
    for i in range(0, count):
        value = str(row[i])
        fixed_print(value, width, " ")
    print()

university_db.close()


