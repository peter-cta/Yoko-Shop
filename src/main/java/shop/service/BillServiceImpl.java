package shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.AccountDAO;
import shop.dao.BillDAO;
import shop.dao.CartDAO;
import shop.dao.CartItemsDAO;
import shop.dao.CustomerDAO;
import shop.dao.ProductDAO;
import shop.model.Account;
import shop.model.Bill;
import shop.model.Cart;
import shop.model.CartItems;
import shop.model.Customer;
import shop.model.Product;

@Service
public class BillServiceImpl implements BillService{
	
	@Autowired
	private BillDAO billDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private CartItemsDAO cartItemsDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public int save(Bill bill) {
		// TODO Auto-generated method stub
		return billDAO.save(bill);
	}

	@Override
	public int update(Bill bill) {
		// TODO Auto-generated method stub
		return billDAO.update(bill);
	}

	@Override
	public Bill get(Integer id) {
		// TODO Auto-generated method stub
		return billDAO.get(id);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return billDAO.delete(id);
	}

	@Override
	public List<Bill> list() {
		// TODO Auto-generated method stub
		return billDAO.list();
	}

	@Override
	public Bill getTopBill() {
		// TODO Auto-generated method stub
		return billDAO.getTopBill();
	}

	@Override
	public int createBill(int accId, int cartID, String address) {
		Account acc = accountDAO.get(accId);
		Customer customer = customerDAO.getCustomerFromAccID(acc.getId());
		Cart cart = cartDAO.get(cartID);
		Bill bill = new Bill(acc.getUsername(), customer.getPhone(), address, cart.getTotal()+5, "");
		billDAO.save(bill);
		Bill bill2 = billDAO.getTopBill();
		List<CartItems> cartItems = cartItemsDAO.getIteminCart(cartID);
		for (CartItems item : cartItems) {
			item.setBill_id(bill2.getId());
			cartItemsDAO.update(item);
		}
		return bill2.getId();
	}

	@Override
	public List<List> getListProductInBill(List<Bill> listBill) {
		List<List> listProductInBill = new ArrayList<List>();
		for (Bill bill : listBill) {
			List<Product> listProduct = new ArrayList<Product>();
			List<CartItems> listItems = cartItemsDAO.getIteminBill(bill.getId());
			for (CartItems item : listItems) {
				Product product = productDAO.get(item.getProduct_id());
				listProduct.add(product);
			}
			listProductInBill.add(listProduct);
		}
		
		return listProductInBill;
	}

	@Override
	public List<List> getListCartItemsInBill(List<Bill> listBill) {
		List<List> listCartItemsInBill = new ArrayList<List>();
		for (Bill bill : listBill) {
			List<CartItems> listItems = cartItemsDAO.getIteminBill(bill.getId());
			listCartItemsInBill.add(listItems);
		}
		return listCartItemsInBill;
	}

	@Override
	public List<Customer> getListCustomerFromBill(List<Bill> listBill) {
		List<Customer> lisCustomers = new ArrayList<Customer>();
		for (Bill bill : listBill) {
			int accId = accountDAO.getId(bill.getName());
			Customer customer = customerDAO.getCustomerFromAccID(accId);
			lisCustomers.add(customer);
		}		
		return lisCustomers;
	}

}
