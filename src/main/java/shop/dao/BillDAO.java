package shop.dao;

import java.util.List;

import shop.model.Bill;

public interface BillDAO {
	public int save(Bill bill);
	public int update(Bill bill);
	public Bill get(Integer id);
	public int delete(Integer id);
	public List<Bill> list();
	public Bill getTopBill();
}
