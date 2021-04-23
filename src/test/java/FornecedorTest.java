import dao.FornecedorDAO;
import org.junit.Assert;
import org.junit.Test;
import pojos.Fornecedor;

import java.util.List;
import java.util.Random;

public class FornecedorTest {

    FornecedorDAO fornecedorDAO = new FornecedorDAO();

    private Fornecedor createFornecedor(int cnpj, String name, String phone) {
        try {
            Fornecedor newFornecedor = new Fornecedor(Integer.toString(cnpj), name, phone);
            fornecedorDAO.adicionar(newFornecedor);
            return newFornecedor;
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    public void shouldCreateFornecedor() {
        Random rand = new Random();
        int cnpj = rand.nextInt();
        String name = "Fornecedor TOP";
        String phone = "81 973248342";

        Fornecedor fornecedorMock = this.createFornecedor(cnpj, name, phone);
        Assert.assertNotNull(fornecedorMock);
        Assert.assertEquals(Integer.toString(cnpj), fornecedorMock.getCnpj());
        Assert.assertEquals(name, fornecedorMock.getNome());
        Assert.assertEquals(phone, fornecedorMock.getTelefone());

        try {
            List<Fornecedor> fornecedores = fornecedorDAO.listar();
            Assert.assertEquals(1, fornecedores.size());
        } catch (Exception e) {
        }
    }

    @Test
    public void shouldListZeroFornecedorWhenNoOneWasCreated() {
        try {
            List<Fornecedor> fornecedores = fornecedorDAO.listar();
            Assert.assertNotNull(fornecedores);
            Assert.assertEquals(0, fornecedores.size());
        } catch (Exception e) {}
    }

    @Test
    public void shouldListOneFornecedorWhenOneWasCreated() {
        try {
            Random rand = new Random();
            int cnpj = rand.nextInt();
            String name = "Fornecedor TOP";
            String phone = "81 973248342";

            List<Fornecedor> fornecedoresBeforeCreate = fornecedorDAO.listar();

            Assert.assertNotNull(fornecedoresBeforeCreate);
            Assert.assertEquals(0, fornecedoresBeforeCreate.size());

            this.createFornecedor(cnpj, name, phone);

            List<Fornecedor> fornecedoresAfterCreate = fornecedorDAO.listar();

            Assert.assertNotNull(fornecedoresAfterCreate);
            Assert.assertEquals(1, fornecedoresAfterCreate.size());

            Fornecedor fornecedorCreated = fornecedorDAO.procurar(Integer.toString(cnpj));

            Assert.assertNotNull(fornecedorCreated);
            Assert.assertEquals(name, fornecedorCreated.getNome());
            Assert.assertEquals(phone, fornecedorCreated.getTelefone());
            Assert.assertEquals(Integer.toString(cnpj), fornecedorCreated.getCnpj());

        } catch (Exception e) {
            System.out.println("shouldListOneFornecedorWhenOneWasCreated failed");
        }
    }
}
