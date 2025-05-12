import java.util.Scanner;

class Ponto2d {
    int x;
    int y;

    String mostrarPonto(){
        return String.format("(%s,%s)",x,y);
    }

    double calcularDistancia(){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }

    double calcularDistanciaDe(Ponto2d p2){
        double ponto = Math.abs(Math.pow((x-p2.x),2)+Math.pow((y-p2.y),2));
        return Math.sqrt(ponto);
    }

    double calcularDistanciaTotal(Ponto2d[] pontos){
        double distanciaTotal = 0.0;
        if (pontos.length > 0) {
            distanciaTotal += pontos[0].calcularDistancia();


            for (int i = 1; i < pontos.length; i++) {
                distanciaTotal += pontos[i].calcularDistanciaDe(pontos[i - 1]);
            }
        }

        return distanciaTotal;
        }
    
        public static void main(String[] args) {
            Scanner entradaDados= new Scanner(System.in);
            Ponto2d q1 = new Ponto2d();
            Ponto2d q2 = new Ponto2d();

            q1.x = entradaDados.nextInt();
            q1.y = entradaDados.nextInt();

            q2.x = entradaDados.nextInt();
            q2.y = entradaDados.nextInt();

            System.out.println("Ponto: " + q1.mostrarPonto());
            System.out.println("Distancia da origem: " + q1.calcularDistancia());
            System.out.println("Distancia entre dois pontos " + q1.calcularDistanciaDe(q2));
            Ponto2d[] pontos= {q1,q2};
            System.out.println("Soma consecutiva: " + q1.calcularDistanciaTotal(pontos));

    
    
            entradaDados.close();
        }
    
}