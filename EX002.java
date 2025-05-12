import java.util.Scanner;

public class EX002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] numerosPorExtenso = {
            "zero", "um", "dois", "três", "quatro", 
            "cinco", "seis", "sete", "oito", "nove"
        };
        
        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();
        
        String numeroStr = String.valueOf(numero);
        
        for (int i = 0; i < numeroStr.length(); i++) {
            int digito = Character.getNumericValue(numeroStr.charAt(i));
            System.out.print(numerosPorExtenso[digito]);
            
            if (i < numeroStr.length() - 1) {
                System.out.print(", ");
            }
        }
        
        scanner.close();
    }
}
