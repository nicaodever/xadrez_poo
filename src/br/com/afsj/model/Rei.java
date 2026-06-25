package br.com.afsj.model;

import br.com.afsj.control.Xadrez;

public class Rei extends Peca{

    @Override
    public boolean movimentoOK(int x, int y) {
        if (posX == -1 && posY == -1) {
            return true;
        }

        if (!condicoesParaSeMover(x, y)) {
            return false;
        }

        if (casaDestinoEstaEmXeque(x, y)) {
            return false;
        }

        return true;
    }

    private boolean condicoesParaSeMover(int x, int y){
                                                        // pos x | pos y
        return ((posX == x - 1) && (posY == y - 1)) ||  //   -1  |  -1   (noroeste)
                ((posX == x) && (posY == y - 1)) ||     //   =   |  -1   (norte)
                ((posX == x + 1) && (posY == y - 1)) || //   +1  |  -1   (nordeste)
                ((posX == x - 1) && (posY == y)) ||     //   -1  |  =    (oeste)
                ((posX == x + 1) && (posY == y)) ||     //   +1  |  =    (leste)
                ((posX == x - 1) && (posY == y + 1)) || //   -1  |  +1   (sudoeste)
                ((posX == x) && (posY == y + 1)) ||     //   =   |  +1   (sul)
                ((posX == x + 1) && (posY == y + 1));   //   +1  |  +1   (suldeste)
    }

    private boolean roque(Peca torre){
        if(cor == Xadrez.corBRANCA){
            if(torre.seMovimenteou || this.seMovimenteou)
                return false;

        }

        if(cor == Xadrez.corPRETA){
            if(torre.seMovimenteou || this.seMovimenteou)
                return false;
        }

        return false;
    }

        public boolean estaEmXeque() {
        ArrayPecas inimigos;
    
        if (cor == Xadrez.corBRANCA) {
            inimigos = Tabuleiro.listaPretas;
        } else {
            inimigos = Tabuleiro.listaBrancas;
        }
    
        return !inimigos.posicaoLivreAtaque(posX, posY);
        }
    
        public boolean casaDestinoEstaEmXeque(int x, int y) {
        ArrayPecas inimigos;
    
        if (cor == Xadrez.corBRANCA) {
            inimigos = Tabuleiro.listaPretas;
        } else {
            inimigos = Tabuleiro.listaBrancas;
        }
    
        return !inimigos.posicaoLivreAtaque(x, y);
    }

    /*funcionalidade em desenvolvimento
        public boolean roque(Peca torre, ArrayPecas pecasDaMesmaCor) {
    
        // Regra 1: rei e torre nunca podem ter se movido
        if (this.seMovimenteou || torre.seMovimenteou) {
            return false;
        }
    
        // Regra 2: devem estar na mesma linha
        if (this.getPosY() != torre.getPosY()) {
            return false;
        }
    
        // Regra 3: não pode haver peças entre eles
        int menorX = Math.min(this.getPosX(), torre.getPosX());
        int maiorX = Math.max(this.getPosX(), torre.getPosX());
    
        for (int x = menorX + 1; x < maiorX; x++) {
            if (pecasDaMesmaCor.pecaPosicao(x, this.getPosY()) != null) {
                return false;
            }
        }
    
        // Regra 4: definir posições finais
        int posFinalRei;
        int posFinalTorre;
    
        // Roque pequeno (torre à direita)
        if (torre.getPosX() > this.getPosX()) {
            posFinalRei = this.getPosX() + 2;
            posFinalTorre = this.getPosX() + 1;
        }
        // Roque grande (torre à esquerda)
        else {
            posFinalRei = this.getPosX() - 2;
            posFinalTorre = this.getPosX() - 1;
        }
    
        // Regra 5: mover logicamente as peças
        this.mover(posFinalRei, this.getPosY());
        torre.mover(posFinalTorre, torre.getPosY());
    
        return true;
    } */
}
