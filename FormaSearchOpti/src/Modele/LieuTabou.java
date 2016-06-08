package Modele;

/**
 *
 * @author Justine GROLEAU, Gwendoline GOMEZ et Thomas PERISSIER
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
     * @param lieuTabou
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
     * @param anciennete
     */
    public void setAnciennete(int anciennete) {
        this.anciennete = anciennete;
    }
}