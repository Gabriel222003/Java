import java.util.Scanner;

public class EX003 {
    public static void main(String[] args) {
        String[] conectores = {"e", "do", "da", "dos", "das", "de", "di", "du"};
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome completo:");
        String nome = scanner.nextLine();
        
        String[] palavras = nome.split(" ");
        
        StringBuilder iniciais = new StringBuilder();
        
        for (String palavra : palavras) {
            boolean isConector = false;

            for (String conector : conectores) {
                if (palavra.equalsIgnoreCase(conector)) {
                    isConector = true;
                    break;
                }
            }
            if (!isConector && !palavra.isEmpty()) {
                iniciais.append(palavra.toUpperCase().charAt(0));
            }
        }
        
        System.out.println("Iniciais: " + iniciais.toString());
        
        scanner.close();
    }
}
