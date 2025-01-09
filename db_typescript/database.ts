import mysql, { Connection, FieldPacket, Query, QueryError} from 'mysql2';
import { DB_DATA } from './db.config'; // Database connection configuration
import { PrintableFactory } from './util/PrintableFactory';

// Create a connection to the database
const connection: Connection = mysql.createConnection({
    host: DB_DATA.HOST,
    user: DB_DATA.USER,
    password: DB_DATA.PASSWORD,
    database: DB_DATA.DATABASE
});

// Open the MySQL connection
connection.connect((err: QueryError | null) => {
    if(err) throw err;
})
// Used for printing formatted messages
const printable = PrintableFactory.createPrintable();
const width = 17;

// Execute query
const result:Query = connection.query('SELECT * FROM student', (err: QueryError | null, results: any, fields: FieldPacket[]) => {
    if(err) 
        printable.print(err.message);

    // Print table header
    fields.forEach((field: FieldPacket) => {
        printable.fixed_print(field.name, width, ' ');
    });
    printable.print('\n');
    printable.fixed_print('', width * fields.length, '-');
    printable.print('\n');
    // Print table data
    results.forEach((result: any) => {
        fields.forEach((field: FieldPacket) => {
            const columnLabel: string = (field.name);
            const columnValue: string = result[columnLabel].toString();
            printable.fixed_print(columnValue, width, ' ');
        });
        printable.print('\n');
    });
});

result.on('end', () => {
    connection.end();
});