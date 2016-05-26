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
        String fichier ="C:\\Users\\Epulapp\\Documents\\ProjetOptiDiscrete\\FormaSearch\\Sources\\LieuxPossibles.txt";
        List<LieuFormation> formations = Utilitaire.getLieuFormationFichier(fichier);
        /*for(LieuFormation f:formations){
            System.out.println(f.toString());
        }*/
    }
    
}
