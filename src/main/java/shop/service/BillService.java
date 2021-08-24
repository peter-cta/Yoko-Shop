package shop.service;

import java.util.List;

import shop.model.Bill;
import shop.model.Customer;

public interface BillService {
	public int save(Bill bill);
	public int update(Bill bill);
	public Bill get(Integer id);
	public int delete(Integer id);
	public List<Bill> list();
	public Bill getTopBill();
	public int createBill(int accId, int cartID, String address);
	public List<List> getListProductInBill(List<Bill> listBill);
	public List<List> getListCartItemsInBill(List<Bill> listBill);
	public List<Customer> getListCustomerFromBill(List<Bill> listBill);
}
