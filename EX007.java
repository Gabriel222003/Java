import java.util.Scanner;

public class EX007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine().toUpperCase();
        
        for (int i = 1; i <= nome.length(); i++) {
            System.out.println(nome.substring(0, i));
        }
        
        scanner.close();
    }
}
