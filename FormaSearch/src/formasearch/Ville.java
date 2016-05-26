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
public class Ville {
    
    protected String id;
    protected String nom;
    protected String codePostal;
    protected double longitude;
    protected double latitude;
    
    public double getDistance(Ville v){
        
        double earthRadius = 6371; //km
        
        double latDistance = Math.toRadians(latitude-v.latitude);
        double longDistance = Math.toRadians(longitude-v.longitude);
        
        double a = Math.sin(latDistance/2) * Math.sin(latDistance/2) +
                   Math.cos(Math.toRadians(v.latitude)) * Math.cos(Math.toRadians(latitude)) *
                   Math.sin(longDistance/2) * Math.sin(longDistance/2);
        
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        
        return earthRadius * c;
      
    }

    public Ville(){      
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
    
    
    
}
