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
public class Solution {
    
    private double cout;
    
    private List<LieuFormation> formationsChoisies;
    private List<Agence> agences;
    
    public Solution(){
        
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public List<LieuFormation> getFormationsChoisies() {
        return formationsChoisies;
    }

    public void setFormationsChoisies(List<LieuFormation> formationsChoisies) {
        this.formationsChoisies = formationsChoisies;
    }

    /**
     * @return the agences
     */
    public List<Agence> getAgences() {
        return agences;
    }

    /**
     * @param agences the agences to set
     */
    public void setAgences(List<Agence> agences) {
        this.agences = agences;
    }
    
    
            
}
