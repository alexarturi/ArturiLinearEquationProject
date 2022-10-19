import java.util.Scanner;

 class LinearEquationRunner {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.print("Enter coordinate 1: ");
        String str = scan.nextLine();
        int x1 = Integer.parseInt(str.substring(1,str.indexOf(",")));
        int y1 = Integer.parseInt(str.substring(str.indexOf(",")+2, str.length()-1));
        System.out.print("Enter coordinate 2: ");
        String str2 = scan.nextLine();
        int x2 = Integer.parseInt(str2.substring(1,str2.indexOf(",")));
        int y2 = Integer.parseInt(str2.substring(str2.indexOf(",")+2, str2.length()-1));

        if (x1 == x2) {
            System.out.println("These points are on a vertical line: x = " + x1);
        } else {
            LinearEquation line = new LinearEquation(x1, y1, x2, y2);
            System.out.println(line.lineInfo());
            System.out.println();
            System.out.print("Enter a value for x: ");
            double testX = scan.nextDouble();
            System.out.println(line.coordinateForX(testX));
        }

    }
}
