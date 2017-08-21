package model;

public enum Locality {
	ALMIRANTEBROWN("Almirante Brown"),
	AVELLANEDA("Avellaneda"),
	BERAZATEGUI("Berazategui"),
	ENSENADA("Ensenada"),
	ESCOBAR("Escobar"),
	EZEIZA("Ezeiza"),
	FLORENCIOVARELA("Florencio Varela"),
	LAMATANZA("La Matanza"),
	LAPLATA("La Plata"),
	LANUS("Lanús"),
	LOMASDEZAMORA("Lomas de Zamora"),
	MERLO("Merlo"),
	MORENO("Moreno"),
	PILAR("Pilar"),
	QUILMES("Quilmes"),
	SANFERNANDO("San Fernando"),
	SANISIDRO("San Isidro"),
	SANMIGUEL("San Miguel"),
	TIGRE("Tigre");
	
	private final String localityName;
	
	Locality(String name){
		this.localityName = name;
	}
	
	public String getLocalityName(){
		return this.localityName;
	}
}
