import java.util.Random;

public class Luta {
    // Atributos
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    //Métodos Públicos
    public void marcarLuta(Lutador l1, Lutador l2) {
        if (l1.getCategoria().equals(l2.getCategoria())
        && l1 != l2) {
            this.aprovada = true;
            this.desafiado = l1;
            this.desafiante = l2;
        } else {
            this.aprovada = false;
            this.desafiado = null;
            this.desafiante = null;
        }
    }

    public void lutar() {
        if (this.aprovada) {
            System.out.println("### DESAFIADO ###");
            this.desafiado.apresentar();
            System.out.println("## DESAFIANTE ###");
            this.desafiante.apresentar();

            //Pontos de Vantagem
            int v1 = 0;
            int v2 = 0;

            if (this.desafiante.getVitorias() > this.desafiado.getVitorias()) {
                v1 += 2;
            } else if (this.desafiante.getVitorias() < this.desafiado.getVitorias()) {
                v2 += 2;
            }
            if (this.desafiante.getPeso() > this.desafiado.getPeso()) {
                v1 += 1;
            } else if (this.desafiante.getPeso() < this.desafiado.getPeso()) {
                v2 += 1;
            }
            if (this.desafiante.getAltura() > this.desafiado.getAltura()) {
                v1 += 1;
            } else if (this.desafiante.getAltura() < this.desafiado.getAltura())
                v2 += 1;

            Random aleatorio = new Random();
            Random aleatorio2 = new Random();
            v1 += (1 + aleatorio.nextInt(5));
            v2 += (1 + aleatorio2.nextInt(5));
            System.out.println("Pontos de vantagem: L1:" + v1 +" L2:" + v2);

            System.out.println("=========RESULTADO DA LUTA==========");
            if (v1 > v2) {
                System.out.println("O vencedor da luta foi o " + this.desafiante.getNome());
            } else if (v1 == v2) {
                System.out.println("A luta empatou!!");
            } else {
                System.out.println("O vencedor da luta foi o " + this.desafiado.getNome());
            }
            System.out.println("====================================");
        } else {
            System.out.println("A luta não pode acontecer!");
        }
    }

    //Métodos Especiais
    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
}
