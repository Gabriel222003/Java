import java.util.Scanner;

public class EX01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Letras = scanner.nextLine();

        String numeros = "01234567890";
        String vogais = "AEIOU";

        int countnumero = 0;
        int contagem = 0;
        
        System.out.println("Numero de caracteres:" + Letras.replaceAll("\\s", "").length());
        System.out.println("Em maisculo: " + Letras.toUpperCase());

        for(int i = 0; i < Letras.length(); i++){
            if(vogais.indexOf(Letras.toUpperCase().charAt(i)) != -1){
                contagem++;
            }
        }
        System.out.println("Numero de vogais: " + contagem);
        
        for(int i = 0; i < Letras.length(); i++){
            if(numeros.indexOf(Letras.charAt(i)) != -1){
                countnumero++;
            }
        }
        System.out.println("Quantidade de numeros: " + countnumero);
        scanner.close();
    }
}
