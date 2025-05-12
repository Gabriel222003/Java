class GrupoInteiros {
    int[] grupo;
    int tamanhoAtual;

    public GrupoInteiros() {
        this.grupo = new int[100];
        for (int i = 0; i < grupo.length; i++) {
            grupo[i] = -1;
        }
        this.tamanhoAtual = 0;
    }

    public boolean inserirDado(int posicao, int valorDado) {
        if (posicao >= 0 && posicao < 100 && valorDado >= 1 && valorDado <= (1 << 20) && (valorDado & (valorDado - 1)) == 0) {
            grupo[posicao] = valorDado;
            tamanhoAtual++;
            return true;
        }
        return false;
    }

    public int removerElemento(int posicao) {
        if (posicao >= 0 && posicao < 100 && grupo[posicao] != -1) {
            int removido = grupo[posicao];
            grupo[posicao] = -1;
            tamanhoAtual--;
            return removido;
        }
        return -1;
    }

    public int encontrarMaior() {
        int maior = -1;
        for (int valor : grupo) {
            if (valor > maior) {
                maior = valor;
            }
        }
        return maior;
    }

    public int encontrarMenor() {
        int menor = Integer.MAX_VALUE;
        for (int valor : grupo) {
            if (valor != -1 && valor < menor) {
                menor = valor;
            }
        }
        return (menor == Integer.MAX_VALUE) ? -1 : menor;
    }



    public static void main(String[] args) {
        GrupoInteiros grupo = new GrupoInteiros();

        grupo.inserirDado(0, 128);
        grupo.inserirDado(1, 1);
        grupo.inserirDado(2, 2);
        grupo.inserirDado(3, 64);

        int removido = grupo.removerElemento(2);
        System.out.println("removido: " + removido);

        int maior = grupo.encontrarMaior();
        System.out.println("Maior: " + maior);

        int menor = grupo.encontrarMenor();
        System.out.println("Menor: " + menor);
    }
}
