package menusearch;

import java.util.ArrayList;
import java.util.stream.Stream;

import exception.NoMenusFoundException;
import model.Menu;
import model.MenuManager;

public abstract class MenuSearchCriteria {

	private MenuManager menuManager;
	private Object searchCriteria;

	public Menu[] menuSearch() throws NoMenusFoundException {
		ArrayList<Menu> allMenus = this.getMenuManager().getAllMenusOffered();
		Stream<Menu> menuSearchResult = allMenus.stream()
				.filter(m -> this.getPropertyToCompare(m) == this.getSearchCriteria());

		Menu[] result = menuSearchResult.toArray(Menu[]::new);
		if (!this.areElementsAsAResult(result)) {
			throw new NoMenusFoundException("No se han encontrado resultados para su búsqueda");
		}
		return result;
	}

	public boolean areElementsAsAResult(Menu[] result) {
		return !(result.length == 0);
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