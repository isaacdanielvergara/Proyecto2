/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package proyecto2;

import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author danie
 */
public class principalController implements Initializable {
    
    Calendar calendario = new GregorianCalendar();
    
    public int dia = calendario.get(Calendar.DATE);
    public int mes = calendario.get(Calendar.MONTH);
    public int año = calendario.get(Calendar.YEAR);
    public static String fecha;
    public int diav, mesv, añov;
    
    @FXML 
    private TableView<producto> tabla;
    @FXML
    private TableColumn<producto, String> id;
    @FXML
    private TableColumn<producto, String> nom;
    @FXML
    private TableColumn<producto, String> fechal;
    @FXML
    private TableColumn<producto, String> fechav;
    @FXML
    private TableColumn<producto, Float> preciou;
    public static ObservableList<producto> productos = FXCollections.observableArrayList();
    
    @FXML
    private TextField txtfechal, txtfechav;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calendario.add(Calendar.DATE, 31);
        diav = calendario.get(Calendar.DATE);
        mesv = calendario.get(Calendar.MONTH);
        añov = calendario.get(Calendar.YEAR);
        calendario.add(Calendar.DATE, -31);
        txtfechal.setText(String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año) );
        fecha = txtfechal.getText();
        txtfechav.setText(String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov) );
         
        id.setCellValueFactory(new PropertyValueFactory<producto, String>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<producto, String>("nombre"));
        fechal.setCellValueFactory(new PropertyValueFactory<producto, String>("fechal"));
        fechav.setCellValueFactory(new PropertyValueFactory<producto, String>("fechav"));
        preciou.setCellValueFactory(new PropertyValueFactory<producto, Float>("preciou"));
        tabla.setItems(productos);
        // TODO
    }    
    
}
