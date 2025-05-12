import java.util.Scanner;

class Bhaskara {
    float A;
    float B;
    float C;

    double[] calculoRaizes(){
        double bhas = Math.pow(B, 2) - 4*A*C;

        if (bhas > 0) {
        double Raiz1 = (-B + Math.sqrt(bhas))/(2*A);
        double Raiz2 = (-B - Math.sqrt(bhas))/(2*A);
        return new double[]{Raiz1, Raiz2};
        }

        else if (bhas == 0) {
            double Raiz1 = (-B + Math.sqrt(bhas))/(2*A);
            return new double[]{Raiz1};
        }

        else{
            return null;
        }
        
    }

    public static void main(String[] args) {
        Scanner entradaDados= new Scanner(System.in);
        Bhaskara q1 = new Bhaskara();

        System.out.print("A: ");
        q1.A = entradaDados.nextFloat();
        System.out.print("B: ");
        q1.B = entradaDados.nextFloat();
        System.out.print("C: ");
        q1.C = entradaDados.nextFloat();

        double[] raizes = q1.calculoRaizes();

        if (raizes != null) {
            if (raizes.length == 2) {
                System.out.printf("Raiz 1: %.2f\nRaiz 2: %.2f", raizes[0], raizes[1]);
            } else {
                System.out.printf("Raiz : %.2f", raizes[0]);
            }
        } else {
            System.out.println("As raízes são complexas e não podem ser calculadas.");
        }

        entradaDados.close();
    }

    
}