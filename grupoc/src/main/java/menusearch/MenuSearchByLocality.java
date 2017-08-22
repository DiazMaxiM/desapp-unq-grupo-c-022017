package menusearch;

import model.Locality;
import model.Menu;

public class MenuSearchByLocality extends MenuSearchCriteria {

	public MenuSearchByLocality(Locality locality){
		super.setSearchCriteria(locality);
	}

	@Override
	public Object getPropertyToCompare(Menu menu) {
		return menu.getService().serviceLocality();
	}

}
