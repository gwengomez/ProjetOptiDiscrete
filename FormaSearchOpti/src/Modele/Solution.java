package Modele;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Justine GROLEAU, Gwendoline GOMEZ et Thomas PERISSIER
 */
public class Solution {
    
    private double cout;
    
    private List<LieuFormation> formationsChoisies;
    private List<Agence> agences;
    
    public Solution(){
        formationsChoisies = new ArrayList<>();
        agences = new ArrayList<>();
    }

    /**
     * @return the cout
     */
    public double getCout(){
        return cout;
    }
    
    /**
     * @param cout
     */
    public void setCout(double cout){
        this.cout = cout;
    }

    /**
     * @return the formationsChoisies
     */
    public List<LieuFormation> getFormationsChoisies(){
        return formationsChoisies;
    }

    /**
     * @param formationsChoisies
     */
    public void setFormationsChoisies(List<LieuFormation> formationsChoisies){
        this.formationsChoisies = formationsChoisies;
    }
    
    /**
     * Ajoute un lieu de formation dans la liste des lieux de formation utilisés par la solution
     * @param lieuFormation
     */
    public void addFormationChoisie(LieuFormation lieuFormation){
        formationsChoisies.add(lieuFormation);
    }
    
    /**
     * Supprime un lieu de formation de la liste des lieux de formation utilisés par la solution
     * @param lieuFormation
     */
    public void removeFormationChoisie(LieuFormation lieuFormation){
        formationsChoisies.remove(lieuFormation);
    }
    
    /**
     * @return the agences
     */
    public List<Agence> getAgences(){
        return agences;
    }
    
    /**
     * @param agences
     */
    public void setAgences(List<Agence> agences){
        this.agences = agences;
    }    
}