package menusearch;

import java.util.ArrayList;
import java.util.stream.Stream;

import exception.NoMenusFoundException;
import model.Menu;
import model.MenuManager;
import model.SearchResult;

public abstract class MenuSearchCriteria {

	private MenuManager menuManager;
	private Object searchCriteria;

	public ArrayList<SearchResult> menuSearch() throws NoMenusFoundException {
		ArrayList<Menu> menusOrdered = this.orderMenus();
		ArrayList<SearchResult> searchResult = new ArrayList<SearchResult>();
		menusOrdered.forEach(menu -> searchResult.add(new SearchResult(menu)));

		return searchResult;
	}

	public ArrayList<Menu> orderMenus() throws NoMenusFoundException {
		ArrayList<Menu> allMenus = this.getMenuManager().getAllMenusOffered();

		Stream<Menu> menuSearchResult = allMenus.stream()
				.filter(m -> this.getPropertyToCompare(m) == this.getSearchCriteria());

		ArrayList<Menu> resultInArray = new ArrayList<>();
		menuSearchResult.forEach(resultInArray::add);

		if (!this.areElementsAsAResult(resultInArray)) {
			throw new NoMenusFoundException("No se han encontrado resultados para su búsqueda");
		}

		return resultInArray;
	}

	public boolean areElementsAsAResult(ArrayList<Menu> result) {
		return result.size() != 0;
	}

	public Object getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(Object criteria) {
		this.searchCriteria = criteria;
	}

	public MenuManager getMenuManager() {
		return menuManager;
	}

	public void setMenuManager(MenuManager menuManager) {
		this.menuManager = menuManager;
	}

	public abstract Object getPropertyToCompare(Menu menu);

}
