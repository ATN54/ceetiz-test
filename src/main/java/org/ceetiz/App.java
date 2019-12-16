package org.ceetiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.ceetiz.calcul.CalculImpot;
import org.ceetiz.entreprises.EntrepriseRepository;
import org.ceetiz.entreprises.Entreprise;
import org.ceetiz.entreprises.EntrepriseType;

/**
 * Main class, should be launch for testing the algorithm.
 * Results will be show in console.
 * @author Etienne
 *
 */
public class App 
{
	private EntrepriseRepository repository = new EntrepriseRepository();
	
	/**
	 * Entry point for application
	 * @param args not used.
	 */
    public static void main( String[] args )
    {
    	App app = new App();
    	app.initEntrepise();
    	List<EntrepriseType> enumValues = Arrays.asList(EntrepriseType.values());
    	for( EntrepriseType type : enumValues ) {
    		ArrayList<Entreprise> list = app.getRepository().get( type );
    		for( Entreprise e : list ) {
    	    	double impot = CalculImpot.calculImpotEntrepise( e );
    	    	System.out.println("Impot pour entreprise societé (type=" + e.getType() + ") SIRET! " + e.getSiret() + "=" + impot );
    			
    		}
    	}
    }
    /** 
     * Add all company types in the repository
     */
	public void initEntrepise() {
		Entreprise AUTOentreprise = new Entreprise( EntrepriseType.AUTO, "12345678901234", "Vente via Internet", 1000000D, "12, rue du sentier, 75002, PARIS", .25D);
    	Entreprise SASentreprise= new Entreprise(EntrepriseType.SAS, "43210987654321", "Coiffeur", 1000000D, null,  0.33D);
    	Entreprise SASUentreprise= new Entreprise(EntrepriseType.SASU, "34587698034567", "Boulanger", 1000000D, null,  0.30D);
    	Entreprise SARLentreprise= new Entreprise(EntrepriseType.SARL, "67893245657803", "Boucher", 1000000D, null,  0.31D);
    	repository.regiserEntreprise( EntrepriseType.AUTO, AUTOentreprise );
    	repository.regiserEntreprise( EntrepriseType.SAS, SASentreprise );
    	repository.regiserEntreprise( EntrepriseType.SASU, SASUentreprise );
    	repository.regiserEntreprise( EntrepriseType.SARL, SARLentreprise );
	}
	public EntrepriseRepository getRepository() {
		return repository;
	}
}
