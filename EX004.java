import java.util.Scanner;

public class EX004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o texto:");
        String texto = scanner.nextLine();
        
        int numeroCaracteres = texto.length();

        String[] palavras = texto.trim().split("\\s+");
        
        int numeroPalavras = palavras.length;
        
        if (texto.trim().isEmpty()) {
            numeroPalavras = 0;
        }

        System.out.println("Número total de caracteres: " + numeroCaracteres);
        System.out.println("Número total de palavras: " + numeroPalavras);
        
        scanner.close();
    }
}
