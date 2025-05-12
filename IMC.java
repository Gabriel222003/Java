import java.util.Scanner;

class IMC{
    String Nome;
    float Altura;
    float Peso;

    Double calculoIMC(){
        return Peso/Math.pow(Altura,2);
    }

    public static void main(String[] args) {
        Scanner entradaDados= new Scanner(System.in);
        IMC q1 = new IMC();

        System.out.print("Insira seu nome: ");
        q1.Nome = entradaDados.nextLine();
        System.out.print("Insira seu peso(Kg): ");
        q1.Peso = entradaDados.nextFloat();
        System.out.print("Insira sua altura(m): ");
        q1.Altura = entradaDados.nextFloat();

        System.out.println(q1.Nome);
        System.out.printf("Seu IMC e: %.2f", q1.calculoIMC());
        

        entradaDados.close();
    }
}
