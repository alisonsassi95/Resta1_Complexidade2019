package trabalhocomplexidade_resta1;

/**
 *
 * @author Eduardo Gémerson Rodriogo
 */
public class Jogada {

    /**
    * Atributos que especificam as posições das peças no transcorrer das jogadas
    */
    public int x_origem, y_origem;
    public int x_destino, y_destino;
    public int x_meio, y_meio;
     /**
     * Método construtor que atribuí a posição das peças no transcorrer de uma jogada
     * @param x_origem corresponde a linha da peça de origem
     * @param y_origem corresponde a coluna da peça de origem
     * @param x_meio corresponde a linha da peça central
     * @param y_meio corresponde a coluna da peça central
     * @param x_destino corresponde a linha da peça de destino
     * @param y_destino corresponde a coluna da peça de destino
     */

    public Jogada(int x_origem, int y_origem, int x_meio, int y_meio, int x_destino, int y_destino) {
        this.x_origem = x_origem;
        this.y_origem = y_origem;
        this.x_destino = x_destino;
        this.y_destino = y_destino;
        this.x_meio = x_meio;
        this.y_meio = y_meio;
    }

    @Override
    public String toString() {
        return "" + x_origem + ";" + y_origem
                + ";" + x_meio + ";" + y_meio
                + ";" + x_destino + ";" + y_destino ;
    }
}
