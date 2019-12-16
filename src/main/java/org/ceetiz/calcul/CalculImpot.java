package org.ceetiz.calcul;

import org.ceetiz.entreprises.Entreprise;


/**
 * Computation of taxes for Enterprises
 * @author Etienne
 *
 */
public class CalculImpot {

	 /** Taxes computation for company
	 * 
	 * @param entreprise the company
	 * @return the amount of taxes depending on CA and tax percentage
	 */
	public static double calculImpotEntrepise( Entreprise entreprise) {
		double result = entreprise.getCA() * entreprise.getPourcentageImpot();
		return result;

	}
}
