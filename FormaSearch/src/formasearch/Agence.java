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
public class Agence extends Ville{
    
    private int nbPersonnes;
    
    private LieuFormation lieuFormation;
    private List<LieuTabou> tabou;
    
    public Agence(){
        tabou = new ArrayList<LieuTabou>();
    }
    
    public LieuFormation getLieuFormationPlusProche(List<LieuFormation> formations){
        LieuFormation lieuChoisi = null;
        for(LieuFormation f:formations){
            //Si le lieu a assez de place
            if(f.hasEnoughtPlace(this)){
                if ((lieuChoisi == null) || (f.getDistance(this) < lieuChoisi.getDistance(this))) {
                    if (!tabou.contains(f))
                    lieuChoisi = f;
                }
            }
        }
             
        //On retourne le lieu le plus proche     
        return lieuChoisi;
    }
    
    public LieuFormation getLieuFormationPlusProche(List<LieuFormation> formations, Solution solution){
        LieuFormation lieuChoisi = null;
        double coutChoisi = 0;
        boolean nouvelleSolution = false;
        for(LieuFormation f:formations){
            //Si le lieu a assez de place
            if(f.hasEnoughtPlace(this)){
                if (lieuChoisi == null) {
                    lieuChoisi = f;
                }
                int nbLieu = solution.getFormationsChoisies().size();
                if (!solution.getFormationsChoisies().contains(f))
                    nbLieu++;
                coutChoisi = 3000*nbLieu;
                LieuFormation ancienLieu = this.getLieuFormation();
                this.setLieuFormation(f);
                for (Agence a : solution.getAgences()) {
                    coutChoisi+=a.getNbPersonnes()*0.4*a.getDistance(a.getLieuFormation())*2;
                }

                if (coutChoisi < solution.getCout()) {
                    lieuChoisi = f;
                    nouvelleSolution = true;
                }
                this.setLieuFormation(ancienLieu);
            }
        }
        if (!nouvelleSolution) {
            int maxTabou = 0;
            int minTabou = 0;
            
            if (tabou.size() >= 1) {
                for (LieuTabou lieuTabou : tabou) {
                    if (lieuTabou.getAnciennete() >= maxTabou)
                        maxTabou = lieuTabou.getAnciennete();
                }
                minTabou = maxTabou;
                for (LieuTabou lieuTabou : tabou) {
                    if (lieuTabou.getAnciennete() <= minTabou)
                        minTabou = lieuTabou.getAnciennete();
                }
                LieuTabou tabouAEnlever = null;
                for (LieuTabou lieuTabou : tabou) {
                    if (lieuTabou.getAnciennete() == minTabou) {
                        tabouAEnlever = lieuTabou;
                    }
                }
                tabou.remove(tabouAEnlever);
            }
            tabou.add(new LieuTabou(lieuFormation, maxTabou));
            
            lieuChoisi = getLieuFormationPlusProche(formations);
            int nbLieu = solution.getFormationsChoisies().size();
            LieuFormation ancienLieu = this.getLieuFormation();
            this.setLieuFormation(lieuChoisi);
            if (!solution.getFormationsChoisies().contains(lieuChoisi))
                nbLieu++;
            coutChoisi = 3000*nbLieu;
            
            for (Agence a : solution.getAgences()) {
                coutChoisi+=a.getNbPersonnes()*0.4*a.getDistance(a.getLieuFormation())*2;
            }
            
            this.setLieuFormation(ancienLieu);
            
        }
        
        LieuFormation ancienLieu = this.lieuFormation;
        this.lieuFormation = lieuChoisi;
        ancienLieu.getAgencesAssociees().remove(this);
        if (ancienLieu.getAgencesAssociees().size() == 0) {
            solution.getFormationsChoisies().remove(ancienLieu);
        }
        lieuChoisi.getAgencesAssociees().add(this);
        if (!solution.getFormationsChoisies().contains(lieuChoisi)) {
            solution.getFormationsChoisies().add(lieuChoisi);
        }
        solution.setCout(coutChoisi);
        
        return lieuChoisi;
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
