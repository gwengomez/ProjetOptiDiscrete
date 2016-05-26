/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formasearch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Epulapp
 */
public class LieuFormation extends Ville {
    
    private List<Agence> agencesAssociees;
    
    public LieuFormation(){
        agencesAssociees = new ArrayList<>();
    }
    
    public boolean hasEnoughtPlace(Agence agence){
        int nbPersonnesLieu=0;
        for(Agence a:agencesAssociees){
            nbPersonnesLieu+=a.getNbPersonnes();           
        }
        if((nbPersonnesLieu+agence.getNbPersonnes())>60){
            return false;
        }
        return true;
    } 
    
    //Assigne l'agence au lieu de formation et l'agence au lieu de formation
    public void assignAgence(Agence a){
        agencesAssociees.add(a);
        a.setLieuFormation(this);
    }

    @Override
    public String toString() {
        return "LieuFormation{" + "id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + ", longitude=" + longitude + ", latitude=" + latitude + '}';
    }
    
    
    
}
