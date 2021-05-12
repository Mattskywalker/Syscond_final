package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Responsavel por gerenciar e controlar a tela de menuConsulta.fxml;
 */
public class MenuConsultaController extends MenuController implements Initializable {

    @FXML
    private BorderPane pane;
    @FXML
    private Label labelUsuario;
    @FXML
    private FlowPane formularyPane;

    public void backMenu() {
        setRoot("menu");
    }

    /**
     * metodo usado para chamar a tela de consulta de Visitante.
     */
    public void exibirListarVisitante() {
        Node node;
        try{
            node = FXMLLoader.load(getClass().getResource(
                    "procurarVisitante.fxml"));
            formularyPane.getChildren().clear();
            formularyPane.getChildren().add(node);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * metodo usado para chamar a tela de consulta de Morador.
     */
    public void exibirListarMorador() {
        Node node;
        try{
            node = FXMLLoader.load(getClass().getResource(
                    "procurarMorador.fxml"));
            formularyPane.getChildren().clear();
            formularyPane.getChildren().add(node);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * metodo usado para chamar a tela de consulta de Carro.
     */
    public void exibirListarCarro(){
        Node node;
        try{
            node = FXMLLoader.load(getClass().getResource(
                    "procurarCarro.fxml"));
            formularyPane.getChildren().clear();
            formularyPane.getChildren().add(node);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * metodo usado para chamar a tela de consulta de Funcionario.
     */
    public void exibirListarFuncionario(){

        Node node;
        try{
            node = FXMLLoader.load(getClass().getResource(
                    "procurarFuncionario.fxml"));
            formularyPane.getChildren().clear();
            formularyPane.getChildren().add(node);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * metodo usado para chamar a tela de consulta de Usuario.
     */
    public void exibirListarUsuario(){
        Node node;
        try{
            node = FXMLLoader.load(getClass().getResource(
                    "procurarUsuario.fxml"));
            formularyPane.getChildren().clear();
            formularyPane.getChildren().add(node);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * metodo usado para chamar a tela de consulta de Fornecedor.
     */
    public void exibirListarFornecedor(){
        Node node;
        try{
            node = FXMLLoader.load(getClass().getResource(
                    "procurarFornecedor.fxml"));
            formularyPane.getChildren().clear();
            formularyPane.getChildren().add(node);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    /**
     * metodo usado para chamar a tela de consulta de Apartamento.
     */
    public void exibirListarAp(){
        Node node;
        try{
            node = FXMLLoader.load(getClass().getResource(
                    "procurarApartamento.fxml"));
            formularyPane.getChildren().clear();
            formularyPane.getChildren().add(node);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        writeUser(labelUsuario);
        pane.setOnKeyPressed( (keyEvent) -> {
            if(keyEvent.getCode() == KeyCode.ESCAPE)
                backMenu();
        } );
    }


}
