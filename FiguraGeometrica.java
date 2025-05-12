// Interface FiguraGeometrica
public interface FiguraGeometrica { 
    public String getNomeFigura(); 
    public float getArea(); 
    public float getPerimetro();


// Classe QuadradoS
public class Quadrado implements FiguraGeometrica {
    private float lado;

    public Quadrado(float lado) {
        this.lado = lado;
    }

    @Override
    public String getNomeFigura() {
        return "Quadrado";
    }

    @Override
    public float getArea() {
        return lado * lado;
    }

    @Override
    public float getPerimetro() {
        return 4 * lado;
    }
}

// Classe Retangulo
public class Retangulo implements FiguraGeometrica {
    private float largura;
    private float altura;

    public Retangulo(float largura, float altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public String getNomeFigura() {
        return "Retângulo";
    }

    @Override
    public float getArea() {
        return largura * altura;
    }

    @Override
    public float getPerimetro() {
        return 2 * (largura + altura);
    }
}

// Classe Triangulo
public class Triangulo implements FiguraGeometrica {
    private float base;
    private float altura;
    private float ladoA, ladoB, ladoC;

    public Triangulo(float base, float altura, float ladoA, float ladoB, float ladoC) {
        this.base = base;
        this.altura = altura;
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    @Override
    public String getNomeFigura() {
        return "Triângulo";
    }

    @Override
    public float getArea() {
        return (base * altura) / 2;
    }

    @Override
    public float getPerimetro() {
        return ladoA + ladoB + ladoC;
    }
}

// Classe Losango
public class Losango implements FiguraGeometrica {
    private float diagonalMaior;
    private float diagonalMenor;
    private float lado;

    public Losango(float diagonalMaior, float diagonalMenor, float lado) {
        this.diagonalMaior = diagonalMaior;
        this.diagonalMenor = diagonalMenor;
        this.lado = lado;
    }

    @Override
    public String getNomeFigura() {
        return "Losango";
    }

    @Override
    public float getArea() {
        return (diagonalMaior * diagonalMenor) / 2;
    }

    @Override
    public float getPerimetro() {
        return 4 * lado;
    }
}

// Classe Trapezio
public class Trapezio implements FiguraGeometrica {
    private float baseMaior;
    private float baseMenor;
    private float altura;
    private float ladoA, ladoB;

    public Trapezio(float baseMaior, float baseMenor, float altura, float ladoA, float ladoB) {
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    @Override
    public String getNomeFigura() {
        return "Trapézio";
    }

    @Override
    public float getArea() {
        return ((baseMaior + baseMenor) * altura) / 2;
    }

    @Override
    public float getPerimetro() {
        return baseMaior + baseMenor + ladoA + ladoB;
    }
}

// Classe Piramide
public class Piramide implements FiguraGeometrica {
    private float base;
    private float altura;
    private float apotema;

    public Piramide(float base, float altura, float apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
    }

    @Override
    public String getNomeFigura() {
        return "Pirâmide";
    }

    @Override
    public float getArea() {
        return (base * apotema) / 2 + base * base;
    }

    @Override
    public float getPerimetro() {
        return 4 * base;
    }
}

// Classe Cone
public class Cone implements FiguraGeometrica {
    private float raio;
    private float altura;

    public Cone(float raio, float altura) {
        this.raio = raio;
        this.altura = altura;
    }

    @Override
    public String getNomeFigura() {
        return "Cone";
    }

    @Override
    public float getArea() {
        float geratriz = (float) Math.sqrt((raio * raio) + (altura * altura));
        return (float) (Math.PI * raio * (raio + geratriz));
    }

    @Override
    public float getPerimetro() {
        return (float) (2 * Math.PI * raio);
    }
}

// Classe Cilindro
public class Cilindro implements FiguraGeometrica {
    private float raio;
    private float altura;

    public Cilindro(float raio, float altura) {
        this.raio = raio;
        this.altura = altura;
    }

    @Override
    public String getNomeFigura() {
        return "Cilindro";
    }

    @Override
    public float getArea() {
        return (float) (2 * Math.PI * raio * (raio + altura));
    }

    @Override
    public float getPerimetro() {
        return (float) (2 * Math.PI * raio);
    }
}

// Classe Cubo
public class Cubo implements FiguraGeometrica {
    private float aresta;

    public Cubo(float aresta) {
        this.aresta = aresta;
    }

    @Override
    public String getNomeFigura() {
        return "Cubo";
    }

    @Override
    public float getArea() {
        return 6 * aresta * aresta;
    }

    @Override
    public float getPerimetro() {
        return 12 * aresta;
    }
}

// Classe Esfera
public class Esfera implements FiguraGeometrica {
    private float raio;

    public Esfera(float raio) {
        this.raio = raio;
    }

    @Override
    public String getNomeFigura() {
        return "Esfera";
    }

    @Override
    public float getArea() {
        return (float) (4 * Math.PI * raio * raio);
    }

    @Override
    public float getPerimetro() {
        // Esfera não tem perímetro
        return 0;
    }
}
}
