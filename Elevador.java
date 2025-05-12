import java.util.Scanner;

class Elevador {
    //Parametro!!!!!!!!!!!!
    int andarAtual = 0;
    int andaresPredio = 0;
    int capacidadeElevador = 0;
    int pessoas = 0;

    void inicializar(int capacidadeElevador,int andaresPredio){
        this.capacidadeElevador = capacidadeElevador;
        this.andaresPredio = andaresPredio;
    }

    void entrar(){
        if (pessoas <= capacidadeElevador) {
            this.pessoas++;
        }
        else{
            System.out.println("LOTADO");
        }
    }

    void sair(){
        if (pessoas != 0) {
            this.pessoas--;
        }
        else{
            System.out.println("Elevador esta vazio");
        }
    }

    void subir(){
        if (andarAtual < andaresPredio) {
            this.andarAtual++;
        }
        else{
            System.out.println("Nao tem andar para cima");
        }
    }

    void descer(){
        if (andarAtual != 0) {
            this.andarAtual--;
        }
        else{
            System.out.println("Nao tem andar para baixo");
        }
    }

    boolean estaVazio(){
        if (pessoas == 0) {
            return true;
        }
        else{
            return false;
        }
    }

    int pessoasPresentes(){
        return this.pessoas;
    }



public static void main(String[] args){
    Scanner encontraDados = new Scanner(System.in);
    System.out.print("Capacidade do elevador: ");
    int x = encontraDados.nextInt();
    System.out.print("Andares do predio: ");
    int y = encontraDados.nextInt();
    
    Elevador q1 = new Elevador();
    q1.inicializar(x, y);


    q1.subir();
    q1.subir();
    q1.entrar();
    q1.entrar();
    q1.subir();
    q1.entrar();
    q1.entrar();
    q1.entrar();
    q1.entrar();
    q1.subir();
    q1.entrar();
    q1.entrar();
    q1.descer();
    q1.descer();
    q1.descer();
    q1.descer();
    q1.sair();
    q1.sair();
    q1.sair();
    q1.sair();
    q1.sair();
    
    System.out.println("Este elevador esta vazio: " + q1.estaVazio());
    System.out.println("Quantas pessoas tem: " + q1.pessoasPresentes());
    
    encontraDados.close();
    }
    
}
