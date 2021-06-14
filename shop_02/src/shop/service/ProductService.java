package shop.service;

import java.util.ArrayList;

import shop.dao.ProductDAO;
import shop.vo.CustomVO;
import shop.vo.ProdVO;

public class ProductService {
	private static ProductService service = new ProductService();
	private ProductService() {}
	public ProductDAO dao =ProductDAO.getInstance();
	public static ProductService getInstance() {
		return service;
	}
	
	public ArrayList<ProdVO> productList() {
		return dao.productList();
	}
	public ProdVO prodChoose(String pid) {
		return dao.prodChoose(pid);
	}

	public void cartAdd(String pid, String id, int count) {
		dao.cartAdd(pid,id,count);
	}

	public ProdVO accChk(String acc) {
		return dao.accChk(acc);
	}

	public void insertProd(String pid, String id, int cnt, String address) {
		dao.insertProd(pid,id,cnt,address);		
	}

	public void deleteMax(String pid, int cnt) {
		dao.deleteMax(pid, cnt);
	}

	public ArrayList<ProdVO> accList() {
		return dao.accList();
	}

	public ArrayList<ProdVO> bestChk() {
		return dao.bestChk();
	}
	
	public ArrayList<ProdVO> bestList(ArrayList<ProdVO> prod) {
		return dao.bestList(prod);
	}

	public ArrayList<CustomVO> cusList() {
		return dao.cusList();
	}

	public String chkProdMax(String pid, int count) {
		return dao.chkProdMax(pid,count);
	}

	public ArrayList<CustomVO> customOrder(String type, String[] flower, String plus) {
		return dao.customOrder(type,flower,plus);
	}
}
