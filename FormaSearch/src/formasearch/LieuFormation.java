/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formasearch;

/**
 *
 * @author Epulapp
 */
public class LieuFormation extends Ville {

    private String id;
    private String nom;
    private String codePostal;
    private double longitude;
    private double latitude;
    
    public LieuFormation(){
        
    }
    
    public int getDistance(Ville v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "LieuFormation{" + "id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + ", longitude=" + longitude + ", latitude=" + latitude + '}';
    }
    
    
    
}
