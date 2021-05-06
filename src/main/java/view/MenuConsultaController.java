package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuConsultaController extends MenuController implements Initializable {

    @FXML
    private BorderPane pane;
    @FXML
    private Label labelUsuario;

    public void backMenu() {
        setRoot("menu");
    }

    public void exibirListarVisitante() {}

    public void exibirListarCarro(){}

    public void exibirListarFuncionario(){}

    public void exibirListarUsuario(){}

    public void exibirListarFornecedor(){}

    public void exibirListarAp(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        writeUser(labelUsuario);
        pane.setOnKeyPressed( (keyEvent) -> {
            if(keyEvent.getCode() == KeyCode.ESCAPE)
                backMenu();
        } );
    }


}
