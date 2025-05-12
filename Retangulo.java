import java.util.Scanner;

class Retangulo {
    float lado;
    float altura;
    double calcularArea(){
        return lado*altura;
    }

    double calcularPerimetro(){
        return 2*altura + 2*lado;
    }

    double calcularDiagonal(){
        return Math.sqrt(lado*altura + lado*altura);
    }
    

    public static void main(String[] args) {
        Scanner entradaDados= new Scanner(System.in);
        Retangulo q1 = new Retangulo();

        q1.lado = entradaDados.nextFloat();
        q1.altura = entradaDados.nextFloat();

        System.out.println("Area do retangulo: " + q1.calcularArea());
        System.out.println("Perimetro do retangulo: " + q1.calcularPerimetro());
        System.out.println("Diagonal do retangulo: " + q1.calcularDiagonal());

        entradaDados.close();
    }
}