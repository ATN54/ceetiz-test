package org.ceetiz.entreprises;

/**
 * Definition of a company
 * @author Etienne
 *
 */
public class Entreprise  {

	/**
	 * The regular expression to validate the SIRET of the company
	 */
	private static String SIRET_REG_EXP = "[0-9]{14}";

	/**
	 * Type of company
	 */
	private EntrepriseType type;
	/**
	 * Company could have have an address
	 */
	private String adresse;
	
	/**
	 * The enterprise SIRET
	 */
	private String siret;
	/**
	 * The Enterprise denomination
	 */
	private String denomination;
	/**
	 * the gross sales of the company. 
	 */
	private double ca;
	/** 
	 * The tax for this company 
	 */
	private double percentageImpot;
	
	/**
	 * Constructor for Enterprise
	 * @param type type of company
	 * @param siret n° SIRET
	 * @param denomination Name of the company
	 * @param ca Gross sales of the company
	 * @param adresse address of the company (can be null)
	 * @param impot percentage of tax.
	 */
	public Entreprise( EntrepriseType type, String siret, String denomination, double ca, String adresse, double impot) {
		this.type = type;
		validateSiret( siret );
		this.siret = siret;
		this.denomination = denomination;
		this.ca = ca;
		this.adresse = adresse;
		this.percentageImpot = impot;
		
	}
	
	/**
	 * Helper to validate SIRET (14 digits)
	 * @param siret siret the SIRET to validate
	 * @return true if OK
	 */
	public static boolean validateSiret(String siret ) {
		if ( siret.matches( SIRET_REG_EXP ) == false ) {
			throw new IllegalArgumentException( "Le numéro de SIRET n'est pas valide.");
		}
		return true;
	}

	/**
	 * @return the company SIRET
	 */
	public String getSiret() {
		return siret;
	}
	/**
	 * Validate and set company SIRET
	 * @param siret the company SIRET
	 */
	public void setSiret(String siret) {
		validateSiret(siret);
		this.siret = siret;
	}
	/**
	 * 
	 * @return the company denomination
	 */
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	/**
	 * 
	 * @return the company gross sales
	 */
	public double getCA() {
		return ca;
	}
	/**
	 * Set the company gross sales
	 * @param cA the company gross sales
	 */
	public void setCA(double cA) {
		this.ca = cA;
	}
	
	
	/** 
	 * Get the tax company
	 * @return the tax value
	 */

	public double getPourcentageImpot() {
		return percentageImpot;
	}

	/** 
	 * Set the tax company
	 * @param percentageImpot the tax company (from 0 to 1)
	 */
	public void setPourcentageImpot(double percentageImpot) {
		this.percentageImpot = percentageImpot;
	}
	
	
	

	/**
	 * Getter for company type 
	 * @return the company type
	 */
	public EntrepriseType getType() {
		return type;
	}

	/**
	 * Getter for company address
	 * @return the company address
	 */
	public String getAdresse() {
		return adresse;
	}
	
	/**
	 * Setter for company address
	 * @param adresse the company address
	 */
	public void setAdresse( String adresse ) {
		this.adresse = adresse;
	}

}
