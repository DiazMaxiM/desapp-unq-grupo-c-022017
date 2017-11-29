package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public List<Menu> listMenuForLocality(String locality) {
		MenuRepository repo = (MenuRepository) this.getRepository();
		return repo.findMenuForLocality(locality);
	}
	@Transactional
	public Object listMenuForService(String idService) {
		MenuRepository repo = (MenuRepository) this.getRepository();
		return repo.findMenuForService(idService);
	}
}