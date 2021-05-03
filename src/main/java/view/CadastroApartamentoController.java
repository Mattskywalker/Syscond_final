package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import negocios.ApartamentoNegocios;
import pojos.Apartamento;

import java.awt.*;
import java.io.IOException;

import static view.App.setRoot;

public class CadastroApartamentoController{

    @FXML
    private TextField textFieldNumero;
    @FXML
    private TextField textFieldAndar;
    @FXML
    private TextField textFieldBloco;



    public void cadastrarApartamento(){
        ApartamentoNegocios apartamentoNegocios = new ApartamentoNegocios();

        String numero = textFieldNumero.getText(),
                andar = textFieldAndar.getText(),
                bloco = textFieldBloco.getText();

        Apartamento apartamento = new Apartamento(numero,andar,bloco);

        apartamentoNegocios.cadastrar(apartamento);
    }

    public void voltar(){
        try {
            App.setRoot("menuCadastro");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
