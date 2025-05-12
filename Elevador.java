// Interface Elevador
public interface Elevador {
    void inicializar(int capacidade, int totalAndares);
    void entrar();
    void sair();
    void subir();
    void descer();


// Classe que implementa a interface Elevador
public class ElevadorImpl implements Elevador {
    private int andarAtual;
    private int totalAndares;
    private int capacidade;
    private int pessoasPresentes;

    // Método inicializar: configura capacidade e total de andares; inicializa o andar e pessoas presentes.
    @Override
    public void inicializar(int capacidade, int totalAndares) {
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.andarAtual = 0;  // Inicia no térreo
        this.pessoasPresentes = 0;  // Inicia vazio
    }

    // Método entrar: adiciona uma pessoa se houver espaço.
    @Override
    public void entrar() {
        if (pessoasPresentes < capacidade) {
            pessoasPresentes++;
            System.out.println("Uma pessoa entrou. Pessoas presentes: " + pessoasPresentes);
        } else {
            System.out.println("Elevador cheio! Capacidade máxima: " + capacidade);
        }
    }

    // Método sair: remove uma pessoa se houver alguém dentro.
    @Override
    public void sair() {
        if (pessoasPresentes > 0) {
            pessoasPresentes--;
            System.out.println("Uma pessoa saiu. Pessoas presentes: " + pessoasPresentes);
        } else {
            System.out.println("Elevador vazio!");
        }
    }

    // Método subir: sobe um andar se não estiver no último.
    @Override
    public void subir() {
        if (andarAtual < totalAndares) {
            andarAtual++;
            System.out.println("Subindo para o andar " + andarAtual);
        } else {
            System.out.println("Já está no último andar!");
        }
    }

    // Método descer: desce um andar se não estiver no térreo.
    @Override
    public void descer() {
        if (andarAtual > 0) {
            andarAtual--;
            System.out.println("Descendo para o andar " + andarAtual);
        } else {
            System.out.println("Já está no térreo!");
        }
    }

    // Métodos para obter o status do elevador (opcional)
    public int getAndarAtual() {
        return andarAtual;
    }

    public int getPessoasPresentes() {
        return pessoasPresentes;
    }
}
}
