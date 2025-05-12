import java.util.Scanner;

class ContaCorrente {
    String nomeBanco;
    String nome;
    long cpf;
    float saldo;
    float chequeEspecial;

    void cadastrarConta(String pBanco, String pNome, long pCpf, float pSaldo, float pCheque){
        nomeBanco = pBanco;
        nome = pNome;
        cpf = pCpf;
        saldo = pSaldo;
        chequeEspecial = pCheque;
    }

    void depositar(float valor){
        saldo += valor;
    }

    float sacar(float valor){
        saldo -= valor;
        return saldo;
    }

    float obterSaldo(){
        return saldo;
    }

    void atualizarNomeCliente(String nome){
        this.nome = nome;
    }


    public static void main(String[] args){
        Scanner entradaDados = new Scanner(System.in);
        ContaCorrente[] banco = new ContaCorrente[5];

        for(int i = 0;i < banco.length;i++){
            System.out.println("Nome do Banco: ");
            String NB = entradaDados.nextLine();
            System.out.println("Nome do Cleinte: ");
            String N = entradaDados.nextLine();
            System.out.println("CPF do Cleinte: ");
            Long C = entradaDados.nextLong();
            System.out.println("Saldo do Banco: ");
            float S = entradaDados.nextFloat();
            System.out.println("ChequeEspecial do Banco: ");
            float CH = entradaDados.nextFloat();
            banco[i] = new ContaCorrente();
            banco[i].cadastrarConta(NB, N, C, S, CH);
        }


        banco[0].depositar(9000);
        banco[1].sacar(1543);
        banco[2].obterSaldo();
        banco[3].obterSaldo();
        banco[4].atualizarNomeCliente("São João");

        float SaldoBanco = 0; 
        for(ContaCorrente conta: banco){
            SaldoBanco += conta.obterSaldo();
        }

        System.out.println("Saldo do banco:" + SaldoBanco);

        entradaDados.close();
    }
}
