package org.ceetiz;

import java.util.ArrayList;

import org.ceetiz.calcul.CalculImpot;
import org.ceetiz.entreprises.Entreprise;
import org.ceetiz.entreprises.EntrepriseRepository;
import org.ceetiz.entreprises.EntrepriseType;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    
    @org.junit.Test
    public void testBadSIRET( ) {
    	boolean ret = false;
    	String siret = "123";
    	try {
    		Entreprise.validateSiret(siret);
    	}
    	catch( IllegalArgumentException e ) {
    		ret = true;
    	}
    	assertTrue( ret );

    }
    
    @org.junit.Test
    public void testGoodSIRET( ) {
    	String siret = "12345678901234";
    	Entreprise.validateSiret(siret);
    	
    }
    @org.junit.Test
    public void testImpotCalcul( ) {
    	Entreprise entreprise = new Entreprise(EntrepriseType.AUTO, "12345678901234", "Vente via Internet", 1000000D, "12, rue du sentier, 75002, PARIS", .25D);
    	double impot = CalculImpot.calculImpotEntrepise( entreprise );
    	assertEquals(250000D, impot);
    }
    @org.junit.Test
    public void testImpotCalcul2( ) {
    	Entreprise entreprise = new Entreprise(EntrepriseType.SARL, "12345678901234", "Coiffeur", 1000000D, null, .3333D);
    	double impot = CalculImpot.calculImpotEntrepise( entreprise );
    	assertEquals(333300D, impot);
    }

    @org.junit.Test
    public void testMultipleEntreprises( ) {
    	Entreprise entreprise = new Entreprise(EntrepriseType.SARL, "12345678901234", "Coiffeur", 1000000D, null, .3333D);    
    	Entreprise entreprise2 = new Entreprise(EntrepriseType.SARL, "12345678967834", "Optic 2000", 1000000D, null, .3333D);
    	App app = new App();
    	EntrepriseRepository repository = app.getRepository();
    	repository.regiserEntreprise(EntrepriseType.SARL, entreprise);
    	repository.regiserEntreprise(EntrepriseType.SARL, entreprise2);
    	
    	ArrayList<Entreprise> list = repository.get( EntrepriseType.SARL );
    	assertEquals(list.size(), 2);
    }
}
