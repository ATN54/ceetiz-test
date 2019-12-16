package org.ceetiz.entreprises;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Store all enterprise types
 * @author Etiene
 *
 */
public class EntrepriseRepository {

	/**
	 * Store in a map, the name of the company type is the key
	 */
	private HashMap<EntrepriseType, ArrayList<Entreprise>> map = new HashMap<EntrepriseType, ArrayList<Entreprise>>();
	
	
	/**
	 * Register a new company depending on its type 
	 * @param type the enterprise type
	 * @param entreprise the enterprise parameters
	 */
	public void regiserEntreprise( EntrepriseType type, Entreprise entreprise ) {
		ArrayList<Entreprise> list = map.get( type );
		if ( list == null ) {
			list = new ArrayList<Entreprise>();
			map.put( type, list );
		}
		list.add( entreprise );
	}
	/**
	 * Get the company list with its type, could throws an exception if company type not found  
	 * @param enterpriseType the key of the map
	 * @return the company list for the enterprise type
	 */
	public ArrayList<Entreprise> get( EntrepriseType enterpriseType )  {
		ArrayList<Entreprise> result = map.get( enterpriseType );
		if (result == null) {
			throw new IllegalArgumentException( enterpriseType + " n'est pas connue.");
			
		}
		return result;
			
	}
	
	
}
