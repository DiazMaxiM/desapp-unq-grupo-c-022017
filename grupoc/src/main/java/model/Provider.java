package model;

import java.util.HashMap;
import java.util.List;

public class Provider {
	
	private String name;
	private String logo;
	private Address address;
	private MapPosition mapPosition;
	private String serviceDescription;
	private List<Menu> menusOffered; //Tiene que tener al menos 30 elementos y menos que 200
	private String webDirection;
	private String email;
	private Telephone telephone;
	private HashMap workingHours;
	private List<String> deliveryLocations;


}
