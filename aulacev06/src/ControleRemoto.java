public class ControleRemoto implements Controlador {
    // Atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;

    // Métodos Especiais
    public ControleRemoto () {
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
    }

    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean isLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean isTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }

    // Métodos Abstratos
    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        if (isLigado()) {
            System.out.println("------- MENU -------");
            System.out.println("Está ligado? " + this.isLigado());
            System.out.println("Está tocando? " + this.isTocando());
            System.out.println("Volume: " + this.getVolume());
            for (int i = 1; i <= this.getVolume(); i += 10) {
                System.out.println("|");
            }
            System.out.println("");
        } else {
            System.out.println("Não é possível utilizar essa função desligado.");
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando menu...");
    }

    @Override
    public void maisVolume() {
        if (this.isLigado()) {
            this.setVolume(this.getVolume() + 5);
        } else {
            System.out.println("Despisitivo desligado, impossível aumentar o volume");
        }
    }

    @Override
    public void menosVolume() {
        if (this.isLigado()) {
            this.setVolume(this.getVolume() - 5);
        } else {
            System.out.println("Despositivo desligado, impossível diminuir o volume");
        }
    }

    @Override
    public void ligarMudo() {
        if (this.isLigado() && this.getVolume() > 0) {
            this.setVolume(0);
        } else {
            System.out.println("Dispositivo desligado - Primeiramente ligue-o.");
        }
    }

    @Override
    public void desligarMudo() {
        if (this.isLigado() && this.getVolume() == 0) {
            this.setVolume(30);
        } else {
            System.out.println("Dispositivo desligado - Primeiramente ligue-o.");
        }
    }

    @Override
    public void play() {
        if (this.isLigado() && !this.isTocando()){
            this.setTocando(true);
        } else {
            System.out.println("Não foi possível reproduzir");
        }
    }

    @Override
    public void pause() {
        if (this.isLigado() && this.isTocando()) {
            this.setTocando(false);
        } else {
            System.out.println("Não foi possível pausar");
        }
    }

    @Override
    public void chList() {
        if (this.isLigado()) {
            System.out.println("4.1 - TV SERGIPE");
            System.out.println("5.7 - REDE NÓIA");
            System.out.println("8.1 - CHICO SCIENCE");
            System.out.println("15.4 - ATUM MECHANICS");
        } else {
            System.out.println("Dispositivo desligado");
        }
    }

}
