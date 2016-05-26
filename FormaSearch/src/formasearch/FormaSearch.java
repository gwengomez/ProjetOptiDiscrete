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
public class FormaSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fichierLieuFormation ="C:\\Users\\Epulapp\\Documents\\ProjetOptiDiscrete\\FormaSearch\\Sources\\LieuxPossibles.txt";
        List<LieuFormation> formations = Utilitaire.getLieuFormationFichier(fichierLieuFormation);
        /*for(LieuFormation f:formations){
            System.out.println(f.toString());
        }*/
        
        String fichierAgence ="C:\\Users\\Epulapp\\Documents\\ProjetOptiDiscrete\\FormaSearch\\Sources\\ListeAgences_100.txt";
        List<Agence> agences = Utilitaire.getAgenceFichier(fichierAgence);
        for(Agence a:agences){
            System.out.println(a.toString());
        }
        
        Ville v1 = new Ville();
        v1.setLatitude(46.25);
        v1.setLongitude(6.01667);
        
        Ville v2 = new Ville();
        v2.setLatitude(46.1833);
        v2.setLongitude(5.2);
        
        double distance = v1.getDistance(v2);
        System.out.println(distance);
    }
    
}
