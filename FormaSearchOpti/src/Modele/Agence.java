package Modele;

import Outils.Outils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Justine GROLEAU, Gwendoline GOMEZ et Thomas PERISSIER
 */
public class Agence extends Ville {
    private final static int SIZETABOU = 3;
    
    private int nbPersonne;
    private LieuFormation lieuFormation;
    private final List<LieuTabou> listeTabou;
    
    public Agence(String id, String nom, String codePostal, double longitude, double latitude, int nbPersonne){
        super(id, nom, codePostal, longitude, latitude);
        this.nbPersonne = nbPersonne;
        listeTabou = new ArrayList<>();
    }
    
    /**
     * @return the nbPersonne
     */
    public int getNbPersonne() {
        return nbPersonne;
    }
    
    /**
     * @param nbPersonne
     */
    public void setNbPersonne(int nbPersonne) {
        this.nbPersonne = nbPersonne;
    }
    
    /**
     * @return the lieuFormation
     */
    public LieuFormation getLieuFormation() {
        return lieuFormation;
    }
    
    /**
     * @param lieuFormation
     */
    public void setLieuFormation(LieuFormation lieuFormation) {
        this.lieuFormation = lieuFormation;
    }
    
    /**
     * @return the listeTabou
     */
    public List<LieuTabou> getListeTabou() {
        return listeTabou;
    }
    
    /**
     * Ajoute un lieuFormation dans la listeTabou
     * @param lieuFormation
     */
    public void addToListeTabou(LieuFormation lieuFormation) {
        // Si la taille du tableau est supérieure à la taille de la liste tabou, on supprime le premier élément et on ajoute l'autre à la fin.
        if (listeTabou.size() == SIZETABOU) {
            LieuTabou lieuAncien = new LieuTabou(null, -1);
            for (LieuTabou lieuTabou:listeTabou) {
                if (lieuAncien.getAnciennete() == -1 || lieuAncien.getAnciennete() > lieuTabou.getAnciennete())
                    lieuAncien = lieuTabou;
            }
            listeTabou.remove(lieuAncien);
        }
        
        int maxTabou = -1;
        for (LieuTabou lieuTabou:listeTabou) {
            if (maxTabou == -1 || maxTabou < lieuTabou.getAnciennete())
                maxTabou = lieuTabou.getAnciennete();
        }
        listeTabou.add(new LieuTabou(lieuFormation, maxTabou));
    }
    
    /**
     * Renvoie le lieu de formation de la liste formations le plus proche de l'agence
     * @param formations
     * @return LieuFormation
     */
    public LieuFormation getLieuFormationPlusProche(List<LieuFormation> formations){
        LieuFormation lieuChoisi = null;
        boolean isTabou;
        for (LieuFormation lieuForm:formations){
            isTabou = false;
            // Si le lieu de formation a assez de place
            if (lieuForm.hasEnoughtPlace(this)){
                if ((lieuChoisi == null) || (Outils.getDistance(latitude, longitude, lieuForm.latitude, lieuForm.longitude) < 
                        Outils.getDistance(latitude, longitude, lieuChoisi.latitude, lieuChoisi.longitude))) {
                    for (LieuTabou lieuTab:listeTabou) {
                        if (lieuTab.getLieuTabou() == lieuForm)
                            isTabou = true;
                        
                        if (isTabou)
                            break;
                    }
                    
                    if (!isTabou)
                        lieuChoisi = lieuForm;
                }
            }
        }
             
        // On retourne le lieu de formation le plus proche     
        return lieuChoisi;
    }
    
    /**
     * Renvoie un lieu de formation qui baisse le coût total de la solution
     * @param formations
     * @param solution
     * @return LieuFormation
     */
    public LieuFormation getLieuFormationCout(List<LieuFormation> formations, Solution solution){
        LieuFormation lieuChoisi = null;
        boolean isTabou = false;
        for (LieuFormation lieuForm:formations){
            for (LieuTabou lieuTab:listeTabou){
                if (lieuTab.getLieuTabou() == lieuForm)
                    isTabou = true;

                if (isTabou)
                    break;
            }
            
            if (!isTabou){
                // Si le lieu de formation a assez de place
                if (lieuForm.hasEnoughtPlace(this)){
                    if ((getPriceTransportForAgenceToLF(lieuForm) <= getPriceTransportForAgenceToLF(lieuFormation) && ((lieuForm.getIsOpen() && lieuFormation.getIsOpen())
                        || (!lieuForm.getIsOpen() && lieuFormation.getFermetureLF(this))))
                        || (getPriceTransportForAgenceToLF(lieuForm) - getPriceTransportForAgenceToLF(lieuFormation) <= 3000 && lieuForm.getIsOpen() && lieuFormation.getFermetureLF(this))) {
                        
                        if (lieuChoisi != null){
                            addToListeTabou(lieuChoisi);
                        } else {
                            addToListeTabou(lieuFormation);
                        }
                        
                        lieuChoisi = lieuForm;
                    }
                }
            }
        }
        
        // On retourne le lieu de formation
        if (lieuChoisi != null) {
            return lieuChoisi;
        } else {
            return lieuFormation;
        }
    }
    
    /**
     * Calcul le coût du trajet entre l'agence et le lieu de formation
     * @param LF
     * @return double
     */
    public double getPriceTransportForAgenceToLF(LieuFormation LF)
    {
        double distance = 2 * Outils.getDistance(getLatitude(), getLongitude(), LF.getLatitude(), LF.getLongitude());
        return (0.4 * getNbPersonne() * distance);
    }
    
    @Override
    public String toString() {
        return "Agence{" + "id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + ", longitude=" + longitude + ", latitude=" + latitude + ", nbPersonnes=" + nbPersonne + '}';
    }
}