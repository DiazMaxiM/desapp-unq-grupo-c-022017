package services;

import java.util.List;

import model.Menu;
import repositories.MenuRepository;

public class MenuService extends GenericService<Menu> {

	private static final long serialVersionUID = -2932116622242535843L;

	public List<Menu> listMenuForName(String name) {
		MenuRepository repo = (MenuRepository) this.getRepository();
		return repo.findMenuForName(name);
	}
}