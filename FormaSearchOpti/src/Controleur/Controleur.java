package Controleur;

import Modele.*;
import Outils.*;
import Vue.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Justine GROLEAU, Gwendoline GOMEZ et Thomas PERISSIER
 */
public class Controleur {
    private int tailleEchantillon;
    private List<LieuFormation> listeLF;
    private List<Agence> listeAgences;
    private final Solution solution;
    private final Vue vue;
    
    public Controleur(Vue vue){
        listeAgences = new ArrayList<>();
        listeLF = new ArrayList<>();
        solution = new Solution();
        this.vue = vue;
    }
    
    /**
     * @return the listeLF
     */
    public List<LieuFormation> getListeLF(){
        return listeLF;
    }

    /**
     * @return the listeAgences
     */
    public List<Agence> getListeAgences(){
        return listeAgences;
    }
    
    /**
     * @return the solution
     */
    public Solution getSolution(){
        return solution;
    }
    
    /**
     * Importe la liste des lieux de formation à partir d'un fichier placé en paramètre
     * @param file
     */
    public void importerLF(File file){
        String fichierLieuFormation = file.getAbsolutePath();
        List<LieuFormation> lieuxFormation = Utilitaire.getLieuFormationFichier(fichierLieuFormation);
        listeLF = lieuxFormation;
        tailleEchantillon = (int) lieuxFormation.size() * 50/100;
    }
    
    /**
     * Importe la liste des agences à partir d'un fichier placé en paramètre
     * @param file
     */
    public void importerAgence(File file){
        String fichierAgence = file.getAbsolutePath();
        List<Agence> agences = Utilitaire.getAgenceFichier(fichierAgence);
        listeAgences = agences;
    }
    
    /**
     * Crée un échantillon de lieux de formation utilisé afin de générer la solution
     * @return une liste de LieuFormation
     */
    public List<LieuFormation> creerEchantillon() {
        // Mélange la liste des lieux de formation
        long seed = System.nanoTime();
        Collections.shuffle(listeLF, new Random(seed));
        return listeLF.subList(0, tailleEchantillon);
    }
    
    /**
     * Calcul le coût total des transports entre les agences et les lieux de formation
     * @return double
     */
    public double getCoutTransport(){
        double cout = 0;
        for (Agence agence:listeAgences) {
            LieuFormation lieuFormation = agence.getLieuFormation();
            double distance = 2 * Outils.getDistance(agence.getLatitude(), agence.getLongitude(), lieuFormation.getLatitude(), lieuFormation.getLongitude());
            cout += 0.4 * agence.getNbPersonne() * distance;
        }
        return cout;
    }
    
    /**
     * Calcul le coût total d'ouverture des lieux de formation
     * @return double
     */
    public double getCoutOuvertureLF(){
        double cout = 0;
        for (LieuFormation lieuFormation:solution.getFormationsChoisies()) {
            if (lieuFormation.getIsOpen())
                cout += 3000;
        }
        return cout;
    }
    
    /**
     * Calcul le coût total de la formation
     * @return double
     */
    public double getCoutTotal(){
        return getCoutOuvertureLF() + getCoutTransport();
    }
    
    /**
     * Test si le lieu de formation est encore utilisé
     * @param lieuFormation
     * @return boolean
     */
    public boolean getFermetureLF(LieuFormation lieuFormation){
        return lieuFormation.getAgencesAssociees().isEmpty();
    }
    
    /**
     * Génération de la solution initiale
     */
    public void genererSolutionInitiale(){
        // On crée l'échantillon qui sera utilisé pour générer cette solution initiale
        List<LieuFormation> echantillonLF = creerEchantillon();
        for (Agence agence:listeAgences){
            LieuFormation lieuFormation = agence.getLieuFormationPlusProche(echantillonLF);
            agence.setLieuFormation(lieuFormation);
            lieuFormation.assignAgence(agence);
            lieuFormation.setIsOpen(true);
            if (!solution.getFormationsChoisies().contains(lieuFormation)) {
                solution.addFormationChoisie(lieuFormation);
            }
        }
        
        double coutTotal = getCoutOuvertureLF() + getCoutTransport();
        solution.setCout(coutTotal);
        solution.setAgences(listeAgences);
    }
    
    /**
     * Génération d'une meilleur solution
     * @param nbIteration
     */
    public void genererSolution(int nbIteration){
        int i=0;
        while (i<nbIteration){
            for (Agence agence:listeAgences){
                LieuFormation lieuFormationTemp = agence.getLieuFormation();
                List<LieuFormation> echantillonLF = creerEchantillon();
                
                // On supprime de l'échantillon les lieux de formation de la liste tabou
                agence.getListeTabou().stream().forEach((lieuTabou) -> {
                    echantillonLF.remove(lieuTabou.getLieuTabou());
                });
                
                LieuFormation lieuFormation = agence.getLieuFormationCout(echantillonLF, solution);
                
                // On modifie le lieu de formation associé à l'agence si le coût baisse
                if (lieuFormation != agence.getLieuFormation()) {
                    lieuFormationTemp.getAgencesAssociees().remove(agence);
                    if (getFermetureLF(lieuFormationTemp)) {
                        lieuFormationTemp.setIsOpen(false);
                    }
                    agence.setLieuFormation(lieuFormation);
                    lieuFormation.assignAgence(agence);
                    lieuFormation.setIsOpen(true);
                    
                    if (getFermetureLF(lieuFormationTemp)) {
                        solution.removeFormationChoisie(lieuFormationTemp);
                    }
                    
                    if (!solution.getFormationsChoisies().contains(lieuFormation)) {
                        solution.addFormationChoisie(lieuFormation);
                    }
                    
                    solution.setCout(getCoutTotal());
                } 
            }
            i++;
        }
    }
    
    /**
     * Méthode de lancement des différentes générations de solution
     * @param nbIteration
     */
    public void startTabou(int nbIteration){
        long debut = System.currentTimeMillis();
        
        // Génération d'une solution initiale
        genererSolutionInitiale();
        
        System.out.println("Nombre d'Agence:" + solution.getAgences().size());
        System.out.println("---------------");
        System.out.println("Nombre LF de la solution initiale:" + solution.getFormationsChoisies().size());
        System.out.println("Cout LF : " + getCoutOuvertureLF());
        System.out.println("Cout Transport : " + getCoutTransport());
        System.out.println("Cout total: " + solution.getCout());
        System.out.println("---------------");
        
        genererSolution(nbIteration);
        
        System.out.println("---------------");
        System.out.println("Nombre LF de la solution finale:" + solution.getFormationsChoisies().size());
        System.out.println("Cout LF : " + getCoutOuvertureLF());
        System.out.println("Cout Transport : " + getCoutTransport());
        System.out.println("Cout total: " + solution.getCout());
        System.out.println("---------------");
        
        solution.getAgences().stream().forEach((agence) -> {
            System.out.println("Agence " + agence.getNom() + " - " + agence.getCodePostal() + " : " + agence.getLieuFormation());
        });
        
        long end = System.currentTimeMillis();

        System.out.println(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(end-debut),
                TimeUnit.MILLISECONDS.toSeconds(end-debut)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(end-debut))
        ));
        
        vue.afficheInfos();
    }
    
    /**
     * Renvoie la liste des lieux de formation utilisés
     * @return une liste de LieuFormation
     */
    public List<LieuFormation> getLieuxFormation() {
        List<LieuFormation> lieuxFormation = new ArrayList();
        solution.getFormationsChoisies().stream().filter((lieuFormation) -> (lieuFormation.getIsOpen() && !lieuxFormation.contains(lieuFormation))).forEach((lieuFormation) -> {
            lieuxFormation.add(lieuFormation);
        });
        return lieuxFormation;
    }
    
    /**
     * Renvoie le nombre de participant pour un lieu de formation placé en paramètre
     * @param lieuFormation
     * @return int
     */
    public int getNbParticipantFromLF(LieuFormation lieuFormation){
        int nbPersonne = 0;
        nbPersonne = lieuFormation.getAgencesAssociees().stream().map((agence) -> agence.getNbPersonne()).reduce(nbPersonne, Integer::sum);
        return nbPersonne;
    }
}