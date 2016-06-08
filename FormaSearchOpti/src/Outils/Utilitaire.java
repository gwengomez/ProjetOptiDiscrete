package Outils;

import Modele.LieuFormation;
import Modele.Agence;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Justine GROLEAU, Gwendoline GOMEZ et Thomas PERISSIER
 */
public class Utilitaire {
    
    /**
     * Importe la liste des lieux de formation à partir d'un fichier placé en paramètre
     * @param fichier
     * @return liste de LieuFormation
     */
    public static List<LieuFormation> getLieuFormationFichier(String fichier){
        List<LieuFormation> lieuxFormations = new ArrayList<>();
        
        // Lecture du fichier texte	
        try{
            InputStream is = new FileInputStream(fichier);
            InputStreamReader isr = new InputStreamReader(is);
            try (BufferedReader br = new BufferedReader(isr)) {
                String ligne;
                int i=0;
                while ((ligne = br.readLine()) != null){
                    if(i>0){
                        String[] parts = ligne.split(";");
                        
                        String id = parts[0].replaceAll("\"", "");
                        String nom = parts[1].replaceAll("\"", "");
                        String codePostal = parts[2].replaceAll("\"", "");
                        String longitude = parts[3].replaceAll("\"", "");
                        String latitude = parts[4].replaceAll("\"", "");
                        
                        LieuFormation lieu = new LieuFormation(id, nom, codePostal, Double.parseDouble(longitude), Double.parseDouble(latitude));
                        lieuxFormations.add(lieu);
                    }
                    i++;
                }
            }
            JOptionPane.showMessageDialog(null, "Import terminé", "Information", JOptionPane.INFORMATION_MESSAGE);
        }		
        catch (Exception e){
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de l'import", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return lieuxFormations;
    }
    
    /**
     * Importe la liste des agences à partir d'un fichier placé en paramètre
     * @param fichier
     * @return liste de Agence
     */
    public static List<Agence> getAgenceFichier(String fichier){
        List<Agence> agences = new ArrayList<>();
                
        // Lecture du fichier texte	
        try{
            InputStream is = new FileInputStream(fichier);
            InputStreamReader isr = new InputStreamReader(is);
            try (BufferedReader br = new BufferedReader(isr)) {
                String ligne;
                int i=0;
                while ((ligne=br.readLine())!=null){
                    if(i>0){
                        String[] parts=ligne.split(";");
                        
                        String id = parts[0].replaceAll("\"", "");
                        String nom = parts[1].replaceAll("\"", "");
                        String codePostal = parts[2].replaceAll("\"", "");
                        String longitude = parts[3].replaceAll("\"", "");
                        String latitude = parts[4].replaceAll("\"", "");
                        String nbPersonnes = parts[5].replaceAll("\"", "");
                        
                        Agence agence = new Agence(id, nom, codePostal, Double.parseDouble(longitude), Double.parseDouble(latitude), Integer.parseInt(nbPersonnes));
                        agences.add(agence);
                    }
                    i++;
                }
            }
            JOptionPane.showMessageDialog(null, "Import terminé", "Information", JOptionPane.INFORMATION_MESSAGE);
        }		
        catch (Exception e){
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de l'import", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return agences;
    }
}