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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author isaac
 */
public class principalController implements Initializable {
    
    public pila pila = new pila();
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
    private MenuItem menuid, menulote, menuvence, menuprecio, menunom, menuprom, menumayprom, menumenprom, menumayprecio, menumenprecio;
    @FXML
    private TextField txtfechal, txtfechav, txtid, txtnom, txtprecio;
    @FXML
    private Button menos10, menos1, mas10, mas1, btnregistrar, btncerrar;
    
    @FXML
    private void actionevent(ActionEvent e){
        Object evt = e.getSource();
        if(evt.equals(btnregistrar)){
           String id = txtid.getText();
           String nombre = txtnom.getText();
           String fechalote =txtfechal.getText();
           String fechavencimiento =txtfechav.getText();
           float precio = Float.parseFloat(txtprecio.getText());
           producto producto = new producto(id, nombre, fechalote, fechavencimiento, precio);
           pila.pushproduc(producto);
           txtid.setText("");
           txtnom.setText("");
           txtprecio.setText("");
        }
        if (evt.equals(mas1)){
           calendario.add(Calendar.DATE, 1);
           dia = calendario.get(Calendar.DATE);
           mes = calendario.get(Calendar.MONTH);
           año = calendario.get(Calendar.YEAR);
           calendario.add(Calendar.DATE, 31);
           diav = calendario.get(Calendar.DATE);
           mesv = calendario.get(Calendar.MONTH);
           añov = calendario.get(Calendar.YEAR);
           calendario.add(Calendar.DATE, -31);
           txtfechal.setText(String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año) );
           fecha = txtfechal.getText();
           txtfechav.setText(String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov) );
           
           pila.EliminarProducto();
       }
       
       if (evt.equals(mas10)){
           calendario.add(Calendar.DATE, 10);
           dia = calendario.get(Calendar.DATE);
           mes = calendario.get(Calendar.MONTH);
           año = calendario.get(Calendar.YEAR);
           calendario.add(Calendar.DATE, 31);
           diav = calendario.get(Calendar.DATE);
           mesv = calendario.get(Calendar.MONTH);
           añov = calendario.get(Calendar.YEAR);
           calendario.add(Calendar.DATE, -31);
           txtfechal.setText(String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año) );
           fecha = txtfechal.getText();
           txtfechav.setText(String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov) );
           pila.EliminarProducto();
       }
       
       if (evt.equals(menos1)){
           calendario.add(Calendar.DATE, -1);
           dia = calendario.get(Calendar.DATE);
           mes = calendario.get(Calendar.MONTH);
           año = calendario.get(Calendar.YEAR);
           calendario.add(Calendar.DATE, 31);
           diav = calendario.get(Calendar.DATE);
           mesv = calendario.get(Calendar.MONTH);
           añov = calendario.get(Calendar.YEAR);
           calendario.add(Calendar.DATE, -31);
           txtfechal.setText(String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año) );
           fecha = txtfechal.getText();
           txtfechav.setText(String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov) );
           pila.EliminarProducto();
       }
       
       if (evt.equals(menos10)){
           calendario.add(Calendar.DATE, -10);
           dia = calendario.get(Calendar.DATE);
           mes = calendario.get(Calendar.MONTH);
           año = calendario.get(Calendar.YEAR);
           calendario.add(Calendar.DATE, 31);
           diav = calendario.get(Calendar.DATE);
           mesv = calendario.get(Calendar.MONTH);
           añov = calendario.get(Calendar.YEAR);
           calendario.add(Calendar.DATE, -31);
           txtfechal.setText(String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año) );
           fecha = txtfechal.getText();
           txtfechav.setText(String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov) );
           pila.EliminarProducto();
       }
       if (evt.equals(menuid)){
           String id = JOptionPane.showInputDialog("Ingresa el ID que desea buscar");
           pila.Buscarid(id);
       }
       
       if (evt.equals(menunom)){
           String nombre = JOptionPane.showInputDialog("Ingresa el nombre que desea buscar");
           pila.Buscarnombre(nombre);
       }
       
       if (evt.equals(menuprecio)){
           float precio = Float.parseFloat(JOptionPane.showInputDialog("Ingresa el precio que desea buscar"));
           pila.Buscarprecio(precio);
       }
       
       if (evt.equals(menulote)){
           String fechal = JOptionPane.showInputDialog("Ingresa la fecha de lote del producto que desea buscar");
           pila.Buscarfechal(fechal);
       }
       
       if (evt.equals(menuvence)){
           String fechav = JOptionPane.showInputDialog("Ingresa la fecha de vencimiento del producto que desea buscar");
           pila.Buscarfechav(fechav);
       }
       if (evt.equals(menuprom)){
           float promedio = pila.promedio();
           JOptionPane.showMessageDialog(null, "El promedio es: "+ promedio);
       }
       if (evt.equals(menumenprom)){
           pila.menorpromedio();
       }
       if (evt.equals(menumayprom)){
           pila.mayorpromedio();;
       }
       if (evt.equals(menumayprecio)){
           pila.mayorprecio();
       }
       if (evt.equals(menumenprecio)){
           pila.menorprecio();
       }
       if (evt.equals(btncerrar)){
           System.exit(0);
       }
    }
    @FXML
   private void keyevent (KeyEvent e){
       Object evt = e.getSource();
       if (evt.equals(txtid) || evt.equals(txtprecio)){
           if (!Character.isDigit(e.getCharacter().charAt(0))){
               e.consume();
           }
       }
       
       if (evt.equals(txtnom)){
           if (!Character.isLetter(e.getCharacter().charAt(0))){
               e.consume();
           }
       }
   }
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
        nom.setCellValueFactory(new PropertyValueFactory<producto, String>("nom"));
        fechal.setCellValueFactory(new PropertyValueFactory<producto, String>("fechal"));
        fechav.setCellValueFactory(new PropertyValueFactory<producto, String>("fechav"));
        preciou.setCellValueFactory(new PropertyValueFactory<producto, Float>("preciou"));
        tabla.setItems(productos);
        // TODO
    }    
    
}
