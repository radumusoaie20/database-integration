import { Printable } from "./Printable";

export class Console implements Printable {
    print(input: string): void {
        process.stdout.write(input);
    }
    fixed_print(input: string, width: number, fillChar: string): void {
            if(input.length > width){
                process.stdout.write(input.substring(0, width));
            }
            else{
                const diff = width - input.length;
                process.stdout.write(input);
                for(let i = 0; i < diff; i++){
                    process.stdout.write(fillChar);
            }
        }
    }
}