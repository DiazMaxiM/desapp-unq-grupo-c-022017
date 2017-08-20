package menusearch;

import java.util.ArrayList;
import model.Locality;
import model.Menu;

public class MenuSearchByLocality extends MenuSearchCriteria {

	public MenuSearchByLocality(Locality locality){
		super.setCriteria(locality);
	}
	
	@Override
	public ArrayList<Menu> menuSearch(){
		ArrayList<Menu> result = new ArrayList<Menu>();
//TERMINAR IMPLEMENTACION
		return result;
	}

}
