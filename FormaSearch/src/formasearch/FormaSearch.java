/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formasearch;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Epulapp
 */
public class FormaSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Récupération de la liste des agences à partir du fichier
        String fichierAgence ="C:\\Users\\Epulapp\\Documents\\ProjetOptiDiscrete\\FormaSearch\\Sources\\ListeAgences_100.txt";
        List<Agence> agences = Utilitaire.getAgenceFichier(fichierAgence);
        int nbAgences = (int)agences.size()*20/100;
               
        //Récupération de la liste des formations à partir du fichier
        String fichierLieuFormation ="C:\\Users\\Epulapp\\Documents\\ProjetOptiDiscrete\\FormaSearch\\Sources\\LieuxPossibles.txt";
        List<LieuFormation> formations = Utilitaire.getLieuFormationFichier(fichierLieuFormation);
        
        //On mélange la liste des formations
        long seed = System.nanoTime();
        Collections.shuffle(formations, new Random(seed));
        
        //On prend x lieux de formations eq à 20% du nombre d'agences
        List<LieuFormation> formationsTest = formations.subList(0, nbAgences);
        for(LieuFormation f:formationsTest){
            System.out.println(f.toString());
        }
            
        for(Agence a:agences){
            LieuFormation formation = a.getLieuFormationPlusProche(formations);
        }

        /* Test méthode  getDistance
        Ville v1 = new Ville();
        v1.setLatitude(46.25);
        v1.setLongitude(6.01667);
        
        Ville v2 = new Ville();
        v2.setLatitude(46.1833);
        v2.setLongitude(5.2);
        
        double distance = v1.getDistance(v2);
        System.out.println(distance);*/  
        
    }
    
}
