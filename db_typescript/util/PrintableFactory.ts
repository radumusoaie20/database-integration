import { Console } from "./Console";
import { Printable } from "./Printable";

export class PrintableFactory {
    static createPrintable(): Printable {
        return new Console();
    }
}