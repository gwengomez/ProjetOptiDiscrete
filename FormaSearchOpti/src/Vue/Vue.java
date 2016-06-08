package Vue;

import Controleur.*;
import Modele.LieuFormation;
import Modele.Solution;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Justine GROLEAU, Gwendoline GOMEZ et Thomas PERISSIER
 */
public class Vue extends JFrame {

    protected Controleur controleur;
    protected DecimalFormat df = new DecimalFormat("#.00");
    
    /**
     * Creates new form Vue
     */
    public Vue() {
        controleur = new Controleur(this);
        setTitle("Projet Optimisation Discrète - Méthode tabou");
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanelInfosLF = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelVille = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelCP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelNbAgenceForVille = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelCoutTotalForLF = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListAgenceParLF = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelNbPersonne = new javax.swing.JLabel();
        jLabelNbPlaceRestance = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListLF = new javax.swing.JList();
        jLabelNbLF = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelCoutTotal = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jBImportAgences = new javax.swing.JButton();
        jBImportVille = new javax.swing.JButton();
        jBStartTabou = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        nbIteration = new javax.swing.JTextField();
        jLabelNbAgences = new javax.swing.JLabel();
        jLabelNbVilles = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1500, 1000));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Méthode Tabou", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 102))); // NOI18N

        jPanelInfosLF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanelInfosLF.setPreferredSize(new java.awt.Dimension(400, 700));

        jLabel1.setText("Nom :");

        jLabelVille.setText("Nom de la ville");

        jLabel3.setText("Code postal :");

        jLabelCP.setText("Code postal");

        jLabel2.setText("Nombre d'agence : ");

        jLabelNbAgenceForVille.setText("Nombre d'agence");

        jLabel4.setText("Coût pour ce lieu :");

        jLabelCoutTotalForLF.setText("Coût");

        jScrollPane2.setViewportView(jListAgenceParLF);

        jLabel5.setText("Nombre de personne :");

        jLabel6.setText("Places restantes :");

        jLabelNbPersonne.setText("Nombre de personne");

        jLabelNbPlaceRestance.setText("Nombre de places restantes");

        javax.swing.GroupLayout jPanelInfosLFLayout = new javax.swing.GroupLayout(jPanelInfosLF);
        jPanelInfosLF.setLayout(jPanelInfosLFLayout);
        jPanelInfosLFLayout.setHorizontalGroup(
            jPanelInfosLFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfosLFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfosLFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfosLFLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanelInfosLFLayout.createSequentialGroup()
                        .addGroup(jPanelInfosLFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelInfosLFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelVille, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(jLabelNbAgenceForVille, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelCoutTotalForLF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelInfosLFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(jPanelInfosLFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelNbPersonne, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabelCP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNbPlaceRestance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelInfosLFLayout.setVerticalGroup(
            jPanelInfosLFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfosLFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfosLFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelVille)
                    .addComponent(jLabel3)
                    .addComponent(jLabelCP))
                .addGap(18, 18, 18)
                .addGroup(jPanelInfosLFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelNbAgenceForVille)
                    .addComponent(jLabel5)
                    .addComponent(jLabelNbPersonne))
                .addGap(18, 18, 18)
                .addGroup(jPanelInfosLFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelCoutTotalForLF)
                    .addComponent(jLabel6)
                    .addComponent(jLabelNbPlaceRestance))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(400, 700));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Résultats", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 459));
        jPanel3.setRequestFocusEnabled(false);

        jListLF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListLFMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListLF);

        jLabelNbLF.setText("Nombre de lieu de formation");

        jLabel7.setText("Coût total :");

        jLabel8.setText("Nombre de lieu de formation :");

        jLabelCoutTotal.setText("Coût total");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNbLF, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCoutTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNbLF)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabelCoutTotal)))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paramètres", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jBImportAgences.setText("Importer les agences");
        jBImportAgences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImportAgencesActionPerformed(evt);
            }
        });

        jBImportVille.setText("Importer les villes");
        jBImportVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImportVilleActionPerformed(evt);
            }
        });

        jBStartTabou.setText("Lancer l'agorithme");
        jBStartTabou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBStartTabouActionPerformed(evt);
            }
        });

        jLabel10.setText("Nombre d'itération");

        nbIteration.setText("1000");
        nbIteration.setToolTipText("");
        nbIteration.setFocusTraversalPolicyProvider(true);
        nbIteration.setMinimumSize(new java.awt.Dimension(100, 100));
        nbIteration.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jBImportAgences)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNbAgences, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBImportVille, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel10)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNbVilles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nbIteration, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))))
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBStartTabou, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBImportAgences)
                    .addComponent(jLabelNbAgences, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBImportVille)
                    .addComponent(jLabelNbVilles, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(nbIteration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(jBStartTabou)
                .addContainerGap())
        );

        jBStartTabou.setVisible(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelInfosLF, javax.swing.GroupLayout.DEFAULT_SIZE, 1177, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1177, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanelInfosLF, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListLFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListLFMouseClicked
        jPanelInfosLF.setVisible(true);
        afficheInfosFromLF(controleur.getLieuxFormation().get(jListLF.getSelectedIndex()));
    }//GEN-LAST:event_jListLFMouseClicked

    private void jBStartTabouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBStartTabouActionPerformed
        System.out.println("Taille Liste Agences:" + controleur.getListeAgences().size());
        System.out.println("Taille Liste Lieux de formation:" + controleur.getListeLF().size());
        boolean isOk = isInteger(nbIteration.getText());
        if (controleur.getListeAgences().size() > 0 && controleur.getListeLF().size() > 0 && (!nbIteration.getText().isEmpty() && isOk)) {
            controleur.startTabou(Integer.parseInt(nbIteration.getText()));
        } else {
            JOptionPane.showMessageDialog(null, "Vous devez importer les villes et les agences et entrer un nombre d'itération avant de lancer l'algorithme", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBStartTabouActionPerformed

    private void jBImportVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImportVilleActionPerformed
        JFileChooser dialogue = new JFileChooser();

        dialogue.showOpenDialog(null);

        controleur.importerLF(dialogue.getSelectedFile());
        jLabelNbVilles.setText(controleur.getListeLF().size() + " ville(s) importée(s)");

        if (controleur.getListeAgences().size() > 0 && controleur.getListeLF().size() > 00) {
            jBStartTabou.setVisible(true);
        }
    }//GEN-LAST:event_jBImportVilleActionPerformed

    private void jBImportAgencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImportAgencesActionPerformed
        JFileChooser dialogue = new JFileChooser();

        dialogue.showOpenDialog(null);

        controleur.importerAgence(dialogue.getSelectedFile());
        jLabelNbAgences.setText(controleur.getListeAgences().size() + " agence(s) importée(s)");

        if (controleur.getListeAgences().size() > 0 && controleur.getListeLF().size() > 00) {
            jBStartTabou.setVisible(true);
        }
    }//GEN-LAST:event_jBImportAgencesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Vue().setVisible(true);
        });
    }
    
    public void afficheInfos() {
        DefaultListModel list = new DefaultListModel();
        Solution solution = controleur.getSolution();
        List<LieuFormation> listeLF = solution.getFormationsChoisies();
        int nbAgenceTotal = 0;
        for (LieuFormation lieuFormation:listeLF) {
            int nbAgence = lieuFormation.getAgencesAssociees().size();
            nbAgenceTotal += nbAgence;
            list.addElement(lieuFormation.getNom() + " - " + lieuFormation.getCodePostal() + " ( " + nbAgence + " )");   
        }
        
        jListLF.setModel(list);
        jLabelNbLF.setText(nbAgenceTotal + " | " + listeLF.size());
        
        double sCout = solution.getCout();
        String strSCout = df.format(sCout);
        sCout = Double.parseDouble(strSCout.replace(',', '.'));
        
        jLabelCoutTotal.setText(sCout + " €");
    }
    
    public void afficheInfosFromLF(LieuFormation LF) {
        DefaultListModel list = new DefaultListModel();
        
        jLabelVille.setText(LF.getNom());
        jLabelCP.setText(LF.getCodePostal());
        jLabelNbAgenceForVille.setText(LF.getAgencesAssociees().size() + "");
        jLabelNbPersonne.setText(LF.getNbPersonne() + "");
        jLabelNbPlaceRestance.setText(LF.calculPlaceRestante() + "");
        
        double cout = LF.getPriceForLF();
        String strCout = df.format(cout);
        cout = Double.parseDouble(strCout.replace(',', '.'));
        jLabelCoutTotalForLF.setText(cout + " €");
        
        LF.getAgencesAssociees().stream().forEach((agence) -> {
            double c = agence.getPriceTransportForAgenceToLF(LF);
            String strC = df.format(c);
            c = Double.parseDouble(strC.replace(',', '.'));
            list.addElement(agence.getNom() + " - " + agence.getCodePostal() + " ( " + agence.getNbPersonne() + " personnes soit " + c + " € de transport )");
        });
        jListAgenceParLF.setModel(list);
    }
    
    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBImportAgences;
    private javax.swing.JButton jBImportVille;
    private javax.swing.JButton jBStartTabou;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCP;
    private javax.swing.JLabel jLabelCoutTotal;
    private javax.swing.JLabel jLabelCoutTotalForLF;
    private javax.swing.JLabel jLabelNbAgenceForVille;
    private javax.swing.JLabel jLabelNbAgences;
    private javax.swing.JLabel jLabelNbLF;
    private javax.swing.JLabel jLabelNbPersonne;
    private javax.swing.JLabel jLabelNbPlaceRestance;
    private javax.swing.JLabel jLabelNbVilles;
    private javax.swing.JLabel jLabelVille;
    private javax.swing.JList jListAgenceParLF;
    private javax.swing.JList jListLF;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelInfosLF;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nbIteration;
    // End of variables declaration//GEN-END:variables
}