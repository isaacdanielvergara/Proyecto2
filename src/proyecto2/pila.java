/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class pila {
    
    private Stack<producto> pila;
    public pila(){
        this.pila = new Stack();
    }
    
    public void pushproduc(producto p){
        if(existeid(p.id) != null){
            JOptionPane.showMessageDialog(null,"El ID del producto ya se encuentra registrado");
        }else if(existenom(p.nom) != null){
            JOptionPane.showMessageDialog(null," El nombre del producto ya se encuentra registrado");
        }else{
            pila.push(p);
            principalController.productos.add(p);
            JOptionPane.showMessageDialog(null,"Producto registrado exitosamente!");
        }
    }
    
    public producto existeid (String id){
        producto ide = new producto();
        int i = 0;
        while (i<pila.size()){
            ide = (producto) pila.get(i);
            if(ide.id.equals(id))
                return ide;
            i++;
        }
        ide = null;
        return ide;
    }
    public producto existenom (String nom){
        producto nome = new producto();
        int i = 0;
        while (i<pila.size()){
            nome = (producto) pila.get(i);
            if(nome.id.equals(nom))
                return nome;
            i++;
        }
        nome = null;
        return nome;
    }
    
    public producto vencimiento (String fechav){
        producto vencido = new producto();
        int i = 0;
        while (i<pila.size()){
            vencido = (producto) pila.get(i);
            if(vencido.fechav.equals(fechav))
                return vencido;
            i++;
        }
        vencido = null;
        return vencido;
    }
    public void EliminarProducto (){
      String fecha = principalController.fecha;
        producto Eliminar = new producto ();
        for(producto produ : pila){
            Eliminar = vencimiento(fecha);
            while (Eliminar != null){
                pila.remove(Eliminar);
                principalController.productos.remove(Eliminar);
                Eliminar = vencimiento(fecha);
                
            }
        }
    }
        public void Buscarid (String id){
        for (producto busqueda : pila){
            if (busqueda.id.equals(id)){
                JOptionPane.showMessageDialog(null, "El resultado de busqueda es: \n"
                        + "ID: " + busqueda.id + "\n"
                        + "nombre: " + busqueda.nom + "\n"
                        + "fecha lote: " + busqueda.fechal + "\n"
                        + "fecha vencimiento: " +  busqueda.fechav + "\n"
                        + "Precio: " + busqueda.preciou);
            }
        }
    }
    
    public void Buscarnombre (String nombre){
        for (producto busqueda : pila){
            if (busqueda.nom.equals(nombre)){
                JOptionPane.showMessageDialog(null, "El resultado de busqueda es: \n"
                        + "ID: " + busqueda.id + "\n"
                        + "nombre: " + busqueda.nom + "\n"
                        + "fecha lote: " + busqueda.fechal + "\n"
                        + "fecha vencimiento: " +  busqueda.fechav + "\n"
                        + "Precio: " + busqueda.preciou);
            }
        }
    }
    
    public void Buscarprecio (float precio){
        for (producto busqueda : pila){
            if (busqueda.preciou == (precio)){
                JOptionPane.showMessageDialog(null, "El resultado de busqueda es: \n"
                        + "ID: " + busqueda.id + "\n"
                        + "nombre: " + busqueda.nom + "\n"
                        + "fecha lote: " + busqueda.fechal + "\n"
                        + "fecha vencimiento: " +  busqueda.fechav + "\n"
                        + "Precio: " + busqueda.preciou);
            }
        }
    }
    
    public void Buscarfechal (String fechal){
        for (producto busqueda : pila){
            if (busqueda.fechal.equals(fechal)){
                JOptionPane.showMessageDialog(null, "El resultado de busqueda es: \n"
                        + "ID: " + busqueda.id + "\n"
                        + "nombre: " + busqueda.nom + "\n"
                        + "fecha lote: " + busqueda.fechal + "\n"
                        + "fecha vencimiento: " +  busqueda.fechav + "\n"
                        + "Precio: " + busqueda.preciou);
            }
        }
    }
    
    public void Buscarfechav (String fechav){
        for (producto busqueda : pila){
            if (busqueda.fechav.equals(fechav)){
                JOptionPane.showMessageDialog(null, "El resultado de busqueda es: \n"
                        + "ID: " + busqueda.id + "\n"
                        + "nombre: " + busqueda.nom + "\n"
                        + "fecha lote: " + busqueda.fechal + "\n"
                        + "fecha vencimiento: " +  busqueda.fechav + "\n"
                        + "Precio: " + busqueda.preciou);
            }
        }
    }
        public float promedio (){
        float suma = 0;
        float promedio = 0;
        for (producto prom : pila){
            suma = prom.getPreciou()+ suma;
        }
        promedio = suma/pila.size();
        return promedio;
        
    }
    public void menorpromedio(){
        float promedio = promedio();
        for  (producto prom : pila){
            if (prom.preciou < promedio){
                JOptionPane.showMessageDialog(null, "Los productos menores al promedio son:\n"
                + "ID: " + prom.id + "\n"
                        + "nombre: " + prom.nom + "\n"
                        + "fecha lote: " + prom.fechal + "\n"
                        + "fecha vencimiento: " +  prom.fechav + "\n"
                        + "Precio: " + prom.preciou); 
                
            }
        }
    }
    public void mayorpromedio(){
        float promedio = promedio();
        for  (producto prom : pila){
            if (prom.preciou > promedio){
                JOptionPane.showMessageDialog(null, "Los productos mayores al promedio son:\n"
                        + "ID: " + prom.id + "\n"
                        + "nombre: " + prom.nom + "\n"
                        + "fecha lote: " + prom.fechal + "\n"
                        + "fecha vencimiento: " +  prom.fechav + "\n"
                        + "Precio: " + prom.preciou); 
                
            }
        }
    }
    public producto mayor (){
        producto mayor = new producto();
        float precio = 0;
        for (producto may : pila){
            if (may.preciou>precio){
                mayor = may;
            }
        }
        return mayor; 
    }
    public void mayorprecio(){
       producto mayor = mayor();
       for (producto may : pila){
           if (may.preciou>mayor.preciou){
               mayor= may;
           }
       }
       for (producto may : pila){
           if (may.preciou==mayor.preciou){
               JOptionPane.showMessageDialog(null, "El producto de mayor precio es: \n"
               
                        + "ID: " + may.id + "\n"
                        + "nombre: " + may.nom + "\n"
                        + "fecha lote: " + may.fechal + "\n"
                        + "fecha vencimiento: " +  may.fechav + "\n"
                        + "Precio: " + may.preciou);
           }
       }
    }
     public void menorprecio(){
       producto menor = mayor();
       for (producto men : pila){
           if (men.preciou<menor.preciou){
               menor= men;
           }
       }
       for (producto men : pila){
           if (men.preciou==menor.preciou){
               JOptionPane.showMessageDialog(null, "El producto de menor precio es: \n"
               
                        + "ID: " + men.id + "\n"
                        + "nombre: " + men.nom + "\n"
                        + "fecha lote: " + men.fechal + "\n"
                        + "fecha vencimiento: " +  men.fechav + "\n"
                        + "Precio: " + men.preciou);
           }
       }
    }
}
