package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import negocios.FornecedorNegocios;
import pojos.Fornecedor;
import utils.Campos;

import javax.persistence.Table;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProcuraFornecedorController implements Initializable {

    @FXML
    private TextField textFieldCnpj;
    @FXML
    private FlowPane mainPane;
    @FXML
    private TableView<Campos> tableView = new TableView<Campos>();
    @FXML
    private TableColumn nomeCollumn;
    @FXML
    private TableColumn telefoneCollumn;
    @FXML
    private TableColumn cnpjCollumn;
    @FXML
    private Button deletarFornecedor;

    private Fornecedor fornecedorToDelete = new Fornecedor();

    @FXML
    private void procurarFornecedor(){
        FornecedorNegocios fornecedorNegocios = new FornecedorNegocios();
        String cnpj = textFieldCnpj.getText();


        try{

            Fornecedor fornecedor = new Fornecedor(cnpj);
            fornecedor = fornecedorNegocios.pesquisar(fornecedor);
            System.out.println("Nome do Fornecedor: " + fornecedor.getNome());
            final ObservableList<Campos> dataCampos = FXCollections.observableArrayList(
                    new Campos(fornecedor.getNome(),fornecedor.getTelefone(),fornecedor.getCnpj())
            );
            //Creating columns
            nomeCollumn.setCellValueFactory(new PropertyValueFactory<>("campo1"));
            telefoneCollumn.setCellValueFactory(new PropertyValueFactory("campo2"));
            cnpjCollumn.setCellValueFactory(new PropertyValueFactory("campo3"));
            //Adding data to the table
            ObservableList<String> list = FXCollections.observableArrayList();
            tableView.setItems(dataCampos);
            tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);



        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void voltar(){
        try {
            App.setRoot("menuConsulta");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void deletarFornecedor() {
        FornecedorNegocios fornecedorNegocios = new FornecedorNegocios();
        fornecedorNegocios.deletar(fornecedorToDelete);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mainPane.setOnMousePressed(event -> {

        });
        mainPane.setOnKeyPressed((keyEvent) -> {
            if(keyEvent.getCode() == KeyCode.ENTER){
                procurarFornecedor();
            }
        });

    }


}
