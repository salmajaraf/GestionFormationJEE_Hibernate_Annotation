package model;
//import java.util.List;

import java.util.ArrayList;

import DAO.FormateurDao;
import DAO.FormationDao;
import DAO.LieuDao;




public class TestDao {

    public static void main(String[] args) {
        /*FormationDao formationDao = new FormationDao();

        try {
            
        	
        	// Create  Lieu instance
           Lieu lieu= new Lieu();
            lieu.setId(12);
            lieu.setAdresse("ruealworoud");
            lieu.setVille("CASA");

            // Add the lieu using LieuDao
            //LieuDao.addLieu(lieu);
            Lieu nvlieu= new Lieu();
            nvlieu.setId(10);
            nvlieu.setAdresse("nil");
            nvlieu.setVille("fes");

            // Add the lieu using LieuDao
            //LieuDao.addLieu(nvlieu);

            //System.out.println("lieu added successfully.");
            
            // Modifier lieu
        	
            //LieuDao.updateLieu(1, "nouvelleAdresse", "nouvelleVille");
            //System.out.println("lieu modifiée avec succès.");

            // Sélectionner lieu
            //Lieu selectedLieu = LieuDao.selectLieu(1);
            //System.out.println("lieu sélectionnée : " + selectedLieu);

            // Supprimer lieu
            //LieuDao.deleteLieu(1);
            //System.out.println("lieu supprimée avec succès.");
            
         // Ajouter une formation
            Formation formation = new Formation("Nouveau Thème", lieu);
            formationDao.addFormation(formation);

           

            // Mettre à jour la formation
            int nouveauLieuId = 11; // Remplacez  par l'ID du nouveau lieu
            formationDao.updateFormation(6, "Nouveau Thème 2", nouveauLieuId);


            // Sélectionner la Formation
            Formation selectedFormation = formationDao.selectFormation(1);
            System.out.println("Formation sélectionnée : " + selectedFormation);

            // Supprimer la Formation
            //formationDao.deleteFormation(1);
            //System.out.println("Formation supprimée avec succès.");

        } finally {
            // Close the EntityManagerFactory
            formationDao.closeEntityManagerFactory();
        }*/
       /* FormateurDao formateurDao = new FormateurDao();

        // Test d'ajout de formateur
        Formateur formateur = new Formateur("123456", "Suzy", 30);
        formateurDao.addFormateur(formateur);

        // Test de sélection de formateur
        Formateur selectedFormateur = formateurDao.selectFormateur("123456");
        System.out.println("Selected Formateur: " + selectedFormateur);

        // Test de mise à jour de formateur
        if (selectedFormateur != null) {
            selectedFormateur.setNom("Updated Name");
            formateurDao.updateFormateur(selectedFormateur);
            System.out.println("Formateur Updated: " + selectedFormateur);
        }

        // Test de suppression de formateur
       // formateurDao.deleteFormateur("123456");
       // System.out.println("Formateur Deleted");

        // Fermeture de l'EntityManagerFactory
        formateurDao.closeEntityManagerFactory();*/
    	

    	    
    	// Création d'une instance de Lieu et ajout à la base de données
    	
    	// Création d'une instance de Lieu et ajout à la base de données
    	Lieu lieuExist = new Lieu();
    	lieuExist.setId(13);

    	LieuDao lieuDao = new LieuDao();
    	LieuDao.addLieu(lieuExist);

    	FormationDao formationDao = new FormationDao();
    	FormateurDao formateurDao = new FormateurDao();

    	// Création d'une instance de Formateur
    	Formateur formateur1 = new Formateur("AB45", "EL FAQUIH LOUBNA", 29);
    	formateur1.setFormations(new ArrayList<>());

    	// Création d'une instance de Formation
    	Formation formation1 = new Formation("AI", lieuExist);
    	formation1.setFormateurs(new ArrayList<>());

    	// Association des formations avec les formateurs
    	formateur1.getFormations().add(formation1);

    	// Association des formateurs avec les formations
    	formation1.getFormateurs().add(formateur1);

    	
    	formateurDao.addFormateur(formateur1);
    	formationDao.addFormation(formation1);

    	// Ajout des formateurs et des formations à la base de données
    	try {
    	    System.out.println("ID de la formation après ajout : " + formation1.getId());
    	    System.out.println("Formateurs et formations ajoutés avec succès à la base de données.");
    	} catch (Exception e) {
    	    System.err.println("Erreur lors de l'ajout des formateurs et formations : " + e.getMessage());
    	} finally {
    	    // Fermeture de l'EntityManagerFactory
    	    formateurDao.closeEntityManagerFactory();
    	    formationDao.closeEntityManagerFactory();
    	    lieuDao.closeEntityManagerFactory(); 
    	}


    }
 }
