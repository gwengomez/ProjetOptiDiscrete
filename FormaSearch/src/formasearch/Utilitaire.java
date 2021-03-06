/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Epulapp
 */
public class Utilitaire {
    
    
    // importation fichier (important lieux possibles et formation, lieux agences)
    // calcul distance 2 points
    
    public static List<LieuFormation> getLieuFormationFichier(String fichier){
        List<LieuFormation> formations= new ArrayList<>();
                
        //lecture du fichier texte	
        try{
            InputStream is = new FileInputStream(fichier); 
            InputStreamReader isr =new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
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

                    LieuFormation lieu = new LieuFormation();
                    lieu.setId(id);
                    lieu.setNom(nom);
                    lieu.setCodePostal(codePostal);
                    lieu.setLongitude(Double.parseDouble(longitude));
                    lieu.setLatitude(Double.parseDouble(latitude));

                    formations.add(lieu);
                }
                i++;
                
            }
            br.close(); 
            
        }		
        catch (Exception e){
                System.out.println(e.toString());
        }
        return formations;
    }
    
    public static List<Agence> getAgenceFichier(String fichier){
        List<Agence> agences = new ArrayList<>();
                
        //lecture du fichier texte	
        try{
            InputStream is = new FileInputStream(fichier); 
            InputStreamReader isr =new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
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
                    
                    Agence agence = new Agence();
                    agence.setId(id);
                    agence.setNom(nom);
                    agence.setCodePostal(codePostal);
                    agence.setLongitude(Double.parseDouble(longitude));
                    agence.setLatitude(Double.parseDouble(latitude));
                    agence.setNbPersonnes(Integer.parseInt(nbPersonnes));
                    
                    agences.add(agence);
                }
                i++;
                
            }
            br.close(); 
            
        }		
        catch (Exception e){
                System.out.println(e.toString());
        }
        return agences;
    }
}
