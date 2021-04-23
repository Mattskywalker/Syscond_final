import dao.ApartamentoDAO;
import dao.JPAUtil;
import dao.MoradorDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojos.Apartamento;
import pojos.Carro;
import pojos.Morador;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MoradorTest {

    private final List<Carro> carrosMock = new ArrayList<>();

    private final MoradorDAO moradorDao = new MoradorDAO();
    private final ApartamentoDAO apartamentoDAO = new ApartamentoDAO();



    private Morador createMorador() {
        try {
            Random rand = new Random();
            Apartamento apartamentoMock = new Apartamento(Integer.toString(Math.abs(rand.nextInt())),
                    Integer.toString(Math.abs(rand.nextInt())), "B");
            String cpf = "";
            for(int i = 1; i < 12; i++){
                cpf = cpf.concat(Integer.toString(Math.abs(rand.nextInt((10)))));
            }
            Pattern pattern = Pattern.compile("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})");
            Matcher matcher = pattern.matcher(cpf);
            if (matcher.matches()) cpf = matcher.replaceAll("$1.$2.$3-$4");
            Morador moradorMock = new Morador(cpf, "Mateus Henrique"
                    , apartamentoMock, this.carrosMock);
            this.apartamentoDAO.adicionar(apartamentoMock);
            this.moradorDao.adicionar(moradorMock);

            return moradorMock;
        }catch (Exception e) {
            System.out.println("createMorador failed");
            return null;
        }
    }

    @Before
    public void cleanUp(){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("delete from morador").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void testNome(){
        Assert.assertEquals(
                "Eduardo",
                (new Morador("1", "Eduardo", new Apartamento(), new ArrayList<Carro>())).getNome());
    }

    @Test
    public void testCPF(){
        Assert.assertEquals(
                "1",
                (new Morador("1", "Eduardo", new Apartamento(), new ArrayList<Carro>())).getCpf());
    }

    @Test
    public void shouldCreateMoradorSuccessfully(){
        try {
            Morador moradorMock = this.createMorador();
            Assert.assertNotNull(moradorMock);
            List<Morador> moradores = this.moradorDao.listar();
            Assert.assertEquals(1, moradores.size());
            Morador morador = moradores.get(0);
            Assert.assertEquals(moradorMock.getNome(), morador.getNome());
            Assert.assertEquals(moradorMock.getCpf(), morador.getCpf());
        }catch (Exception e) {
            System.out.println("shouldCreateMoradorSuccessfully failed");
        }
    }

    @Test
    public void shouldListZeroMoradorWhenNoOneWasCreated(){
        List<Morador> moradores = this.moradorDao.listar();
        Assert.assertEquals(0, moradores.size());
    }

    @Test
    public void shouldListOneMoradorWhenOneWasCreated(){
        this.createMorador();
        List<Morador> moradores = this.moradorDao.listar();
        Assert.assertEquals(1, moradores.size());
    }

    @Test
    public void shouldBeAbleToRemoveMorador(){
        Morador moradorMock = this.createMorador();
        List<Morador> moradoresBeforeRemove = this.moradorDao.listar();
        Assert.assertEquals(1, moradoresBeforeRemove.size());
        this.moradorDao.remover(moradorMock);
        List<Morador> moradoresAfterRemove = this.moradorDao.listar();
        Assert.assertEquals(0, moradoresAfterRemove.size());
    }

    @Test
    public void shouldBeAbleToUpdateMorador(){
        String newName = "Mateus Henrique Editado";
        Morador moradorMock = this.createMorador();
        Assert.assertNotNull(moradorMock);

        //System.out.println("nome do vagabundo: " + moradorMock.getNome());
        moradorMock.setNome(newName);

        this.moradorDao.alterar(moradorMock);
        Morador moradorUpdated = this.moradorDao.procurar(moradorMock.getCpf());
        Assert.assertEquals(newName, moradorUpdated.getNome());
    }
}
