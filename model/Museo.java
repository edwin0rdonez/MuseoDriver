/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Yovany
 */
public class Museo {
    private int mu_id;
    private String mu_nombre;

    public Museo() {
        this.mu_id = 0;
        this.mu_nombre = "";
    }
    
    public Museo(int mu_id, String mu_nombre) {
        this.mu_id = mu_id;
        this.mu_nombre = mu_nombre;
    }

    public int getMu_id() {
        return mu_id;
    }

    public void setMu_id(int mu_id) {
        this.mu_id = mu_id;
    }

    public String getMu_nombre() {
        return mu_nombre;
    }

    public void setMu_nombre(String mu_nombre) {
        this.mu_nombre = mu_nombre;
    }
        
}
