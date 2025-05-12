import java.util.Scanner;

class Triangulo {
    float ladoA;
    float ladoB;
    float ladoC;

    double calcularPerimetro(){
        return ladoA + ladoB + ladoC;
    }

    double calcularArea(){
        double p = (ladoA + ladoB + ladoC)/2;
        double R = Math.sqrt(p*(p-ladoA)*(p-ladoB)*(p-ladoC));
        return R;
        
    }

    boolean eTriangulo(){
        if((ladoA + ladoB) > ladoC && (ladoA + ladoC) > ladoB && (ladoB + ladoC) > ladoA) {
            return true;
        }
        else {
            return false;
        }
    }

    boolean eEquilatero(){
        if (ladoA == ladoB && ladoA == ladoC && ladoB == ladoC) {
            return true;
        }
        else{
            return false;
        }
    }

    boolean eEscaleno(){
        if (ladoA != ladoB && ladoA != ladoC && ladoB != ladoC) {
            return true;
        }
        else{
            return false;
        }
    }

    boolean eIsosceles(){
        if (((ladoA == ladoB) && ladoA != ladoC) || ((ladoA == ladoC) && ladoA != ladoB) || ((ladoB == ladoC) && ladoB != ladoA)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner entradaDados= new Scanner(System.in);
        Triangulo q1 = new Triangulo();

        System.out.print("LadoA: ");
        q1.ladoA = entradaDados.nextFloat();
        System.out.print("LadoB: ");
        q1.ladoB = entradaDados.nextFloat();
        System.out.print("LadoC: ");
        q1.ladoC = entradaDados.nextFloat();

        System.out.println("Area do Triangulo: " + q1.calcularArea());
        System.out.println("Perimetro do retangulo: " + q1.calcularPerimetro());
        System.out.println("Diagonal do retangulo: Nao existe");
        System.out.println("E um triangulo: " + q1.eTriangulo());
        System.out.println("E equilatero: " + q1.eEquilatero());
        System.out.println("E escaleno: " + q1.eEscaleno());
        System.out.println("E isosceles: " + q1.eIsosceles());
        

        entradaDados.close();
    }
}
