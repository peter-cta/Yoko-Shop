package shop.service;

import java.util.List;

import shop.model.Product;

public interface ProductService {
	public int save(Product pro);
	public int update(Product pro);
	public Product get(Integer id);
	public int delete(Integer id);
	public List<Product> list();
	public List<Product> getGucci();
	public List<Product> get8seconds();
	public List<Product> getShanghai();
}
