export interface Printable{

    print(input: string): void;

    fixed_print(input: string, width: number, fillChar: string): void;

}