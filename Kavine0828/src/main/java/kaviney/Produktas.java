package kaviney;

//import kaviney.Uzsakymas;

public class Produktas {
	
	private int id = 0;
	private String pav;
	private int mat_kiek;
	//private String busena = "uzsakytas";
	private String mat_vnt;
	private Double kaina;
	private Double kiekis_sand; 	
	
	public Produktas() {
		
	}
	
	public Produktas (String pav, int mat_kiek, String mat_vnt, Double kaina, Double kiekis_sand) {
		
		this.id = 0;
		this.pav = pav;
		this.mat_kiek = mat_kiek;
		this.mat_vnt = mat_vnt;
		this.kaina = kaina;
		this.kiekis_sand = kiekis_sand;
		
		//this.busena = busena;
	}
	
	public Produktas (
			String pav
			, int mat_kiek
			, String mat_vnt
			//, String busena
			, int id
		
			, Double kaina
			, Double kiekis_sand			
		) {
		
		this.id = id;
		this.pav = pav;
		this.mat_kiek = mat_kiek;
		this.mat_vnt = mat_vnt;
		//this.busena = busena;
		this.kaina = kaina;
		this.kiekis_sand = kiekis_sand; 		
	}	
	
	public String toString() {
		
		return 
			this.id 
				+ "/" + this.pav 
				+ "/" + this.mat_kiek
				+ "/" + this.mat_vnt
				//+ "/" + this.busena
				+ "/" + this.kaina 
				+ "/" + this.kiekis_sand
			;
	}
	
	/*
	public boolean isCorrect() {           
		
		boolean is_correct = true;
		
		if ( 
					( trukme_ruosimo < 0 )
				||
					( trukme_kaitinimo < 0 )
			) {
			
			is_correct = false;
		}
		return is_correct;
	}
	
	public boolean equals(Object obj){
    	
        Uzsakymas palyginimui = (Uzsakymas) obj;
        boolean status = false;
        
        if(
        			this.pav.equalsIgnoreCase(palyginimui.pav)
              &&  
                 (
                	this.trukme_ruosimo == palyginimui.trukme_ruosimo
                 )
              &&
              	 (	
              		this.trukme_kaitinimo == palyginimui.trukme_kaitinimo
              	 )
              && 
              	 ( 
              		this.busena == palyginimui.busena
                 )
        ){
            status = true;
        }
        return status;
    }	
*/
	
	public void setId( int id ) {
		
		this.id = id;
	}
	
	public int getId () {
		
		return this.id;
	}
	
	public void setPav( String pav ) {
		this.pav = pav;
	}
	
	public String getPav () {
		
		return this.pav;
	}
	
	public void setMat_vnt( String mat_vnt ) {
		
		this.mat_vnt = mat_vnt;
	}
	
	public String getMat_vnt() {
		
		return this.mat_vnt;
	}
	
	public void setMat_kiek( int Mat_kiek ) {
		
		this.mat_kiek = mat_kiek;
	}
	
	public int getMat_kiek () {
		
		return this.mat_kiek;
	}
	
	
	/*
	public void setBusena( String busena ) {
		
		this.busena = busena;
	}
	
	public String getBusena () {
		
		return this.busena;
	}
	
	public String getLaikas_uzsakymo() {
		return laikas_uzsakymo;
	}

	public void setLaikas_uzsakymo(String laikas_uzsakymo) {
		this.laikas_uzsakymo = laikas_uzsakymo;
	}	
	
	public String getLaikas_pateikimo() {
		return laikas_pateikimo;
	}

	public void setLaikas_pateikimo(String laikas_pateikimo) {
		this.laikas_pateikimo = laikas_pateikimo;
	}	
	
	public String getKlientas() {
		return klientas;
	}

	public void setKlientas(String klientas) {
		this.klientas = klientas;
	}	
	
	
	*/
	public Double getKaina() {
		return kaina;
	}

	public void setKaina(Double kaina) {
		this.kaina = kaina;
	}
	
	public Double getKiekis_sand() {
		return kiekis_sand;
	}

	public void setKiekis_sand(Double kiekis_sand) {
		this.kiekis_sand = kiekis_sand;
	}	
}
