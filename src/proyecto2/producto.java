/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author isaac
 */
public class producto {
    
    String id;
    String nom;
    String fechal;
    String fechav;
    float preciou;
    
    public producto(){
        id = "";
        nom = "";
        fechal = "";
        fechav = "";
        preciou = -1;
    }
    
    public producto(String id, String nom, String fechal, String fechav, float preciou){
        this.id = id;
        this.nom = nom;
        this.fechal = fechal;
        this.fechav = fechav;
        this.preciou = preciou;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFechal() {
        return fechal;
    }

    public void setFechal(String fechal) {
        this.fechal = fechal;
    }

    public String getFechav() {
        return fechav;
    }

    public void setFechav(String fechav) {
        this.fechav = fechav;
    }

    public float getPreciou() {
        return preciou;
    }

    public void setPreciou(float preciou) {
        this.preciou = preciou;
    }
    
    
    
}
