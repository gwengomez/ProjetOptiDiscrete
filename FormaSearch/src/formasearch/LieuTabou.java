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
public class LieuTabou {
    
    private LieuFormation lieuTabou;
    private int anciennete;
    
    public LieuTabou(LieuFormation lieu, int anciennete) {
        lieuTabou = lieu;
        this.anciennete = anciennete;
    }

    /**
     * @return the lieuTabou
     */
    public LieuFormation getLieuTabou() {
        return lieuTabou;
    }

    /**
     * @param lieuTabou the lieuTabou to set
     */
    public void setLieuTabou(LieuFormation lieuTabou) {
        this.lieuTabou = lieuTabou;
    }

    /**
     * @return the anciennete
     */
    public int getAnciennete() {
        return anciennete;
    }

    /**
     * @param anciennete the anciennete to set
     */
    public void setAnciennete(int anciennete) {
        this.anciennete = anciennete;
    }
    
}
