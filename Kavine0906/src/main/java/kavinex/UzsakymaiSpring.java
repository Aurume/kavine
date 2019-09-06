package kavinex;

import java.util.List;
import java.util.ArrayList;

/**
 * Date: 2019-09-03
 * Tai Užsakymai Spring klasė, kurioje atliekami pagrindiniai veiksmai su patiekalais.
 * @author User
 * @version 2019-06
 *
 */

public class UzsakymaiSpring {
	
/**
 * Tai patiekalų masyvas.
 */
	public Patiekalas[] patiekalai;
/**
 * kiek patiekalu is viso, nurodoma kad pradzioje nulis.
 */
	public int kiek_patiekalu = 0;
/**
 * patiekalų masyvas su seka.
 */
	public int[] seka_patiekalu;
/**
 * Metodas, kad nuskaitytu patiekalus ir jų parametrus.
 */
	public Skaitymas skait;
/**
 * 
 * @return grazina patiekalu sarasa.
 */
	
	public Patiekalas[] atiduokPatiekalus() {
		
		return patiekalai;
	}
/**
 * @return grazina kiek viso patiekalu.
 */
	public int kiekPatiekalu() {
		
		return kiek_patiekalu;
	}
/**
 * Metodas, kad butu galima prideti/papildyti patiekalus dedant juos i masyva.
 * @param patiekalas
 */
	public void papildytiPatiekalus( Patiekalas patiekalas ) {
		
		patiekalai [ kiek_patiekalu ] = patiekalas;
		kiek_patiekalu++;
	}
/**
 * cia aprasomi (ar sukuriami?) objektai	
 */
	public UzsakymaiSpring() {
		
		this.patiekalai = new Patiekalas[100];
		this.seka_patiekalu = new int [100];
	}
	
	/**
	 * kostruktorius skirtas testavimui
	 * @param kiek_patiekalu
	 */
	
	public UzsakymaiSpring( int kiek_patiekalu ) {
		
		this.patiekalai = new Patiekalas[ kiek_patiekalu ];
		this.seka_patiekalu = new int [ kiek_patiekalu ];
	}	
/**
 * Metodas, skaitymui is failo, nurodant kokiu objektu reikia.
 * @param s
 */
	public UzsakymaiSpring ( SkaitymasIsFailo s ) {
		
		this.patiekalai = new Patiekalas[100];
		this.seka_patiekalu = new int [100];
		this.skait = s;
	}	
	
	/**
	 * setter'is nustato s reiksme todel vadinasi setS
	 * @param s
	 */
	public void setSkait ( Skaitymas s ) {
		
		this.skait = s;
	}
/**
 * Metodas skirtas nuskaityti duomenis is failo. 
 */
	public void nuskaityti () {
		
		Uzsakymas was_read = null;

		skait.pradeti();
		System.out.println ( "----------- duomenu failo turinys:\n" );
		
		while ( skait.nuskaitytasFragmentas() ) {
			
			was_read = skait.paimtiFragmenta();
			
			patiekalai [ kiek_patiekalu ] = uzsakymas2Patiekalas ( was_read );
			
			kiek_patiekalu++;
			skait.skaitytiFragmenta();
		}	
	}
/**
 * Metodas, kuris israso patiekalus jeigu jis tenkina salyga. 	
 * @param was_read
 * @return gražinami patiekalai
 */
	public Patiekalas uzsakymas2Patiekalas ( Uzsakymas was_read ) {
		
		Patiekalas patiekalas = null;
		
		if ( was_read.isCorrect() ) {
		
			if ( 
						was_read.getTrukme_ruosimo() == 0 
					&&
						was_read.getTrukme_kaitinimo() == 0
				) {
				
				patiekalas = new Patiekalas ( 
						was_read.getPav()
						, was_read.getBusena()
						, was_read.getId()
						, was_read.getLaikas_uzsakymo()
						, was_read.getLaikas_pateikimo()
						, was_read.getKaina()
						, was_read.getKlientas()
					);
				
			} else {
				
				if ( was_read.getTrukme_kaitinimo() == 0 ) {
					
					patiekalas = new RuosiamasPatiekalas (
							
							was_read.getPav()
							, was_read.getBusena()
							, was_read.getId()
							, was_read.getTrukme_ruosimo() 
							, was_read.getLaikas_uzsakymo()
							, was_read.getLaikas_pateikimo()
							, was_read.getKaina()
							, was_read.getKlientas()							
					);
					
				} else {
					
					patiekalas = new KarstasPatiekalas (
							
						was_read.getPav()
						, was_read.getBusena()
						, was_read.getId()
						, was_read.getTrukme_ruosimo()
						, was_read.getTrukme_kaitinimo() 
						, was_read.getLaikas_uzsakymo()
						, was_read.getLaikas_pateikimo()
						, was_read.getKaina()
						, was_read.getKlientas()						
					);						
				}
			}
		}
		return patiekalas;
	}
	
	
	/**
	* virejas ruosia patiekalus, metodas apskaiciuoti kiek laiko uztruks virejas.
	*
	*/
	public void ruostiPatiekalus() {
		
		int virejas_uztruks = 0;
		
		for (int i = 0; i < kiek_patiekalu; i++) {
			
			if ( ( patiekalai [ i ].trukmeRuosimo() > 0 ) && ( patiekalai [ i ].getBusena() == "uzsakytas" ) ) {
				
				patiekalai [ i ].busPradetasRuostiUz( virejas_uztruks ); // 	      prisumuojam prie ruosimo laiko
				
				virejas_uztruks = patiekalai [ i ].trukmeRuosimo();  //               kada galės ruosti kita patiekala
				
				/* ---------------------------------------------------------- tikrinimas
				if (i == 4) {
					
					System.out.println(  
							
						patiekalai [ i ].bus_paruostas_uz + " " + patiekalai [ i ].bus_patiektas_apytiksliai_uz 
					);
					System.out.println( i + " --- " + virejas_uztruks);
				}
				*/
			}
		}
	}	
/**
 * metodas, kuri naudojant suzinom patiekalu ruosimo, kaitinimo trukmę ir kokia seka jie bus gaminami. tai reikalinga tam, kad suzinoti kaip padavejai reikes isnesioti patiekalus.
 */
	public void patiekti() {
/**
 * ar reikia aprasyti padaveja ir int k?
 * jei reikia, tai isivedamas pradinis padavejos laikas, bei k.		
 */
		int padavejos_laikas = 0;
		boolean uzsakymai_ivykdyti = false;
		int k = 0;
		
		for (int i = 0; i < kiek_patiekalu; i++) {	
			
			if ( ! patiekalai [ i ].getBusena().equals ( "uzsakytas" ) ) {
				
				seka_patiekalu [ k ] = i;
				patiekalai [ i ].patiekti ( 0 );
				k++;
				
			}
		}
	
		while ( ! uzsakymai_ivykdyti ) {							// kol yra neivykdytu uzsakymu
			
			uzsakymai_ivykdyti = true;								// o gal jie ivykdyti? 	
			boolean padaveja_pateike = false;						// kol kas padaveja nieko nepatieke
			
			for (int i = 0; i < kiek_patiekalu; i++) {				// perziūrime patiekalu sarasa:
				
				if ( patiekalai [ i ].getBusena().equals( "uzsakytas" ) ) {
				
					if ( patiekalai [ i ].bukle != PatiekaluPateikimoBusenos.Patiektas) { // radom nepatiekta patiekala >>> a1
					
						if ( 
									( patiekalai [ i ].trukmePateikimo() <= padavejos_laikas ) // ar jau paruostas
								&& 
									! padaveja_pateike 											// ir padaveja nieko naptieke
						) {
							/*
							 * patiekalo pateikimas
							 */
							patiekalai [ i ].bukle = PatiekaluPateikimoBusenos.Patiektas;
							padavejos_laikas += 2;
							padaveja_pateike = true; 							// sitos perziūros metu paiteke patiekala
							patiekalai [ i ].patiekti ( padavejos_laikas );
							seka_patiekalu [ k ] = i;
							k++;
						}
						uzsakymai_ivykdyti = false;									// <<< a1 užsakymai dar buvo neįvykdyti
					}
			    }
			}
			if ( ! padaveja_pateike ) {	// jei nieko nepatiekė laikas didėja 1-a minute
				
				padavejos_laikas++;
			}
		}	
	}
/**
 * metodas, kad suzinoti kaip padaveja nesios patiekalus. jų eiliskumas, ir laikas.
 */
	public void isnesioti() {
		
		for(int i = 0; i < kiek_patiekalu; i++ ) {
	
			System.out.println ( 		// isvedam pranesimą, apie patiekimo laika ..
					
					"laikas: " +  patiekalai [ seka_patiekalu [ i ] ].kadaPatiekta() 
					+ " patiekalas: " + patiekalai[ seka_patiekalu [ i ] ].pavadinimas // .. ir pavadinima.
			);	
		}
	}
/**
 * Patiekalu isnesiojimo sarasas?
 * @return grazina patiekalus su papildymu, tarkim jei pridedama daugiau uzsakymu.
 */
	public Iterable<Patiekalas> isnesiotix() {
		
		List<Patiekalas> patiekalaix = new ArrayList<Patiekalas>();
		
		for(int i = 0; i < kiek_patiekalu; i++ ) {
			
			patiekalaix.add( patiekalai [ seka_patiekalu [ i ] ] );	
		}
		return patiekalaix;
	}	
	
	/**
	 * pagalbine testine struktura
	 */
	public void parodyti() {
		
		System.out.println ( "\n----------- užsakymų eiga:\n" );		
	
		for (int i = 0; i < kiek_patiekalu; i++) {
			
			patiekalai [ i ].rodyk();
		}
	}	
}
