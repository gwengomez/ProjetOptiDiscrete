/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formasearch;

/**
 *
 * @author Epulapp
 */
public class Couple {
    private Agence agence;
    private LieuFormation lieuFormation;
    private int anciennete;
    private int ancienneteMax;

    public Couple(){
        anciennete=1;
    }
    
    public void incrementerAnciennete(){
        if(anciennete<ancienneteMax){
            anciennete++;
        }
    }
    
    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public LieuFormation getLieuFormation() {
        return lieuFormation;
    }

    public void setLieuFormation(LieuFormation lieuFormation) {
        this.lieuFormation = lieuFormation;
    }

    public int getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(int anciennete) {
        this.anciennete = anciennete;
    }

    public int getAncienneteMax() {
        return ancienneteMax;
    }

    public void setAncienneteMax(int ancienneteMax) {
        this.ancienneteMax = ancienneteMax;
    }
    
    
    
}
