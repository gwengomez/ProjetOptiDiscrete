/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formasearch;

import java.util.List;

/**
 *
 * @author Epulapp
 */
public class Agence extends Ville{
    
    private int nbPersonnes;
    
    private LieuFormation lieuFormation;
    
    public Agence(){
        
    }
    
    public LieuFormation getLieuFormationPlusProche(List<LieuFormation> formations){
        for(LieuFormation f:formations){
            //Si le lieu a assez de place
            if(f.hasEnoughtPlace(this)){
                //On regarde sa distance
                f.getDistance(this);
                
            }
        }
             
        //On retourne le lieu le plus proche     
        return null;
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

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    public LieuFormation getLieuFormation() {
        return lieuFormation;
    }

    public void setLieuFormation(LieuFormation lieuFormation) {
        this.lieuFormation = lieuFormation;
    }

    @Override
    public String toString() {
        return "Agence{" + "id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + ", longitude=" + longitude + ", latitude=" + latitude + ", nbPersonnes=" + nbPersonnes + '}';
    }
    
    
}
