/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formasearch;

import java.util.ArrayList;
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
    
    private static Solution solution;
    
    public static void main(String[] args) {
        
        //Récupération de la liste des agences à partir du fichier
        String fichierAgence ="Sources/ListeAgences_100.txt";
        List<Agence> agences = Utilitaire.getAgenceFichier(fichierAgence);
        int tailleEchantillon = (int)agences.size()*50/100;
               
        //Récupération de la liste des formations à partir du fichier
        String fichierLieuFormation ="Sources/LieuxPossibles.txt";
        List<LieuFormation> formations = Utilitaire.getLieuFormationFichier(fichierLieuFormation);
        
        
        List<LieuFormation> echantillon = creerEchantillon(formations, tailleEchantillon);
        List<LieuFormation> formationsRetenues = new ArrayList<LieuFormation>();
        
        for(Agence a:agences){
            LieuFormation formation = a.getLieuFormationPlusProche(echantillon);
            a.setLieuFormation(formation);
            formationsRetenues.add(formation);
        }
        
        solution = new Solution();
        
        solution.setAgences(agences);
        solution.setFormationsChoisies(formationsRetenues);
        
        int nbIterations = 10000;
        int i = 0;
        while (true) {
            for (Agence a : solution.getAgences()) {
                echantillon = creerEchantillon(formations, tailleEchantillon);
                a.getLieuFormationPlusProche(echantillon, solution);
            }
            
            if (i%10 == 0) {
                 System.out.println("Cout actuel : " + solution.getCout());
            }
            i++;
        }
        
        
        
    }
    
    public static List<LieuFormation> creerEchantillon(List<LieuFormation> formations, int tailleEchantillon) {
        //On mélange la liste des formations
        long seed = System.nanoTime();
        Collections.shuffle(formations, new Random(seed));
        //On prend x lieux de formations eq à 20% du nombre d'agences
        List<LieuFormation> echantillon = formations.subList(0, tailleEchantillon);
        return echantillon;
    }
    
}
