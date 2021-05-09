package negocios;

import dao.*;
import pojos.Morador;
import pojos.Usuario;

import java.util.List;

public class UsuarioNegocios {

    private UsuarioDaoInterface usuarioDao= new UsuarioDao();

    public void cadastrar(Usuario usuario){

        try{
            usuarioDao.adicionar(usuario);

        }catch(Exception e){
            System.out.println("UsuarioNegocios: Erro: " + e.getMessage());
        }

    }
    public void deletar(Usuario usuario){
        try{
            usuarioDao.remover(usuario);
        }catch(Exception e){
            System.out.println("UsuarioNegocios: Erro: " + e.getMessage());
        }
    }
    public List<Usuario> listarUsuarios(){
        int index = 0;
        List<Usuario> listaUsuarios = null;

        try{
            listaUsuarios = usuarioDao.listar();
            System.out.println("Listando Usuarios de sistemas: ");
            for (Usuario a:listaUsuarios) {
                index++;
                System.out.println("");
                System.out.println(index + "º Usuario:");
                System.out.println("Nome: " + a.getNome());
            }
            return listaUsuarios;
        }catch(Exception e){
            System.out.println("UsuarioNegocios: Erro: " + e.getMessage());
        }
        return listaUsuarios;
    }
    public void alterar(Usuario usuario){

        usuarioDao.alterar(usuario);

    }
    public Usuario pesquisar(String login){
       return usuarioDao.procurar(login);
    }

    public Usuario pesquisar(Usuario usuario){
        return usuarioDao.procurar(usuario);
    }

    public Usuario autenticar(Usuario usuario){

        Usuario user = pesquisar(usuario);

        try{
            user.getLogin();
            if(usuario.getLogin().equals(user.getLogin())
                    &&usuario.getSenha().equals(user.getSenha())){

                return user;
            }else{
                return null;
            }

        }catch(Exception e){

            System.out.println("ERRO: "  + e.getMessage());
            return null;
        }

    }



}
