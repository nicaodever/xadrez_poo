package br.com.afsj.model;

import br.com.afsj.control.Xadrez;

public class Rei extends Peca{

    @Override
    public boolean movimentoOK(int x, int y) {
        if (posX == -1 && posY == -1) {
            return true;
        }
            return condicoesParaSeMover(x,y);
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
}
