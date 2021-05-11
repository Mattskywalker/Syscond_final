package exceptions.produto;

/**
 *  Exception criada caso um produto nao seja achado.
 */

public class ProdutoNaoEncontrado extends Exception {

    private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}
