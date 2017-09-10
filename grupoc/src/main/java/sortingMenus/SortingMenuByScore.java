package sortingMenus;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import model.Menu;
import model.MenuManager;

public class SortingMenuByScore extends SortingMenuCriteria {

	public SortingMenuByScore(MenuManager menuManager) {
		super.setMenuManager(menuManager);
	}

	@Override
	public Map<Menu, Double> menusToOrder() {
		return this.getMenuManager().getScoringManager().getMenusWithAverage();
	}

	@Override
	public ArrayList<Menu> orderMenu() {
		Map<Menu, Double> allMenusInMap = this.orderMap();
		ArrayList<Menu> allMenusInArray = new ArrayList<>();
		for (Menu e : allMenusInMap.keySet()) {
			allMenusInArray.add(e);
		}
		return allMenusInArray;
	}

	public Map<Menu, Double> orderMap() {
		Map<Menu, Double> mapResult = new LinkedHashMap<Menu, Double>();
		List<Menu> myMapKeys = new ArrayList<Menu>(menusToOrder().keySet());
		List<?> misMapValues = new ArrayList<Object>(menusToOrder().values());
		TreeSet<?> orderedSet = new TreeSet<Object>(misMapValues);
		Object[] orderedArray = orderedSet.toArray();
		int size = orderedArray.length;
		for (int i = 0; i < size; i++) {
			mapResult.put(myMapKeys.get(misMapValues.indexOf(orderedArray[i])), (Double) orderedArray[i]);
		}

		return mapResult;
	}
}
