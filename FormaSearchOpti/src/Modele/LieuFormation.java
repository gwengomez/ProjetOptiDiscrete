package Modele;

import Outils.Outils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Justine GROLEAU, Gwendoline GOMEZ et Thomas PERISSIER
 */
public class LieuFormation extends Ville {
    
    private final int placesRestantes;
    private final List<Agence> agencesAssociees;
    private boolean isOpen;
    
    public LieuFormation(String id, String nom, String codePostal, double longitude, double latitude){
        super(id, nom, codePostal, longitude, latitude);
        placesRestantes = 60;
        agencesAssociees = new ArrayList<>();
        isOpen = false;
    }
    
    /**
     * @return the placesRestantes
     */
    public int getPlacesRestantes(){
        return placesRestantes;
    }
    
    /**
     * @return the agencesAssociees
     */
    public List<Agence> getAgencesAssociees() {
        return agencesAssociees;
    }
    
    /**
     * @return the isOpen
     */
    public boolean getIsOpen() {
        return isOpen;
    }
    
    /**
     * @param isOpen
     */
    public void setIsOpen(boolean isOpen){
        this.isOpen = isOpen;
    }
    
    /**
     * Assigne l'agence au lieu de formation et le lieu de formation à l'agence
     * @param agence
     */
    public void assignAgence(Agence agence){
        agencesAssociees.add(agence);
        agence.setLieuFormation(this);
    }
    
    /**
     * Calcul le nombre de personnes présentes dans le lieu de formation
     * @return int
     */
    public int getNbPersonne(){
        int nbPersonne = 0;
        nbPersonne = agencesAssociees.stream().map((agencesAssociee) -> agencesAssociee.getNbPersonne()).reduce(nbPersonne, Integer::sum);
        return nbPersonne;
    }
    
    /**
     * Calcul le nombre de places restantes
     * @return int
     */
    public int calculPlaceRestante(){
        return getPlacesRestantes() - getNbPersonne();
    }
    
    /**
     * Test si le lieu de formation a assez de places pour l'ensemble
     * des personnes de l'agence placée en paramètre
     * @param agence
     * @return boolean
     */
    public boolean hasEnoughtPlace(Agence agence){
        return (calculPlaceRestante() - agence.getNbPersonne()) >= 0;
    } 
    
    /**
     * Calcul le coût pour le lieu de formation
     * @return double
     */
    public double getPriceForLF(){
        double price = 0.0;
        
        // Ajout du coût de la location de la salle et du coût des formateurs
        price += 3000;
        
        // Ajout du coût du trajet pour chaque salarié
        for (Agence agencesAssociee:agencesAssociees) {
            double distance = 2 * Outils.getDistance(agencesAssociee.getLatitude(), agencesAssociee.getLongitude(), getLatitude(), getLongitude());
            price += 0.4 * agencesAssociee.getNbPersonne() * distance;
        }
        
        return price;
    }
    
    /**
     * Test si le lieu de formation est encore utilisé lorsqu'on supprime une agence
     * @param agence
     * @return boolean
     */
    public boolean getFermetureLF(Agence agence){
        return agencesAssociees.contains(agence) && agencesAssociees.size() == 1;
    }
    
    @Override
    public String toString() {
        return "LieuFormation{" + "id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + ", longitude=" + longitude + ", latitude=" + latitude + '}';
    }
}