package Outils;

/**
 *
 * @author Justine GROLEAU, Gwendoline GOMEZ et Thomas PERISSIER
 */
public class Outils {
    
    /**
     * Calcul la distance entre deux villes (Agences, lieux de formation etc...)
     * @param latitude1
     * @param longitude1
     * @param latitude2
     * @param longitude2
     * @return double
     */
    public static double getDistance(double latitude1, double longitude1, double latitude2, double longitude2){
        double radLatitude1, radLatitude2, theta, radTheta, distance;
        
        radLatitude1 = Math.toRadians(latitude1);
        radLatitude2 = Math.toRadians(latitude2);
        
        if (longitude2 < longitude1) {
            theta = longitude1 - longitude2;
        } else {
            theta = longitude2 - longitude1;
        }
        
        radTheta = Math.toRadians(theta);
        distance = Math.sin(radLatitude1) * Math.sin(radLatitude2) + Math.cos(radLatitude1) * Math.cos(radLatitude2) * Math.cos(radTheta);
        distance = Math.acos(distance);
        distance = distance * 180 / (Math.PI);
        distance = distance * 60 * 1.1515;
        
        return distance * 1.609344;
    }
}