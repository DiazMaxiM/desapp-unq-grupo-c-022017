package services;

import java.util.List;

import javax.transaction.Transactional;

import model.Menu;
import repositories.MenuRepository;

public class MenuService extends GenericService<Menu> {

	private static final long serialVersionUID = -2932116622242535843L;

	@Transactional
	public List<Menu> listMenuForName(String name) {
		MenuRepository repo = (MenuRepository) this.getRepository();
		return repo.findMenuForName(name);
	}

	@Transactional
	public List<Menu> listMenus() {
		MenuRepository repo = (MenuRepository) this.getRepository();
		return repo.findAll();
	}

	@Transactional
	public List<Menu> listMenuForCategory(String category) {
		MenuRepository repo = (MenuRepository) this.getRepository();
		return repo.findMenuForCategory(category);
	}

	public List<Menu> listMenuForLocality(String locality) {
		MenuRepository repo = (MenuRepository) this.getRepository();
		return repo.findMenuForLocality(locality);
	}

	public Object listMenuForService(String idService) {
		MenuRepository repo = (MenuRepository) this.getRepository();
		return repo.findMenuForService(idService);
	}
}