package shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.model.Account;
import shop.model.Bill;
import shop.model.Cart;
import shop.model.CartItems;
import shop.model.Customer;
import shop.model.Product;
import shop.service.AccountService;
import shop.service.BillService;
import shop.service.CartItemsService;
import shop.service.CartService;
import shop.service.CustomerService;

@Controller
public class BillController {
	@Autowired
	private BillService billService;	
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CartService cartService ;
	
	@Autowired
	private CartItemsService cartItemsService ;
	
	@Autowired
	private CustomerService customerService ;
	
	@RequestMapping(value = "/createBill", method = RequestMethod.POST)
	public ModelAndView createBill(ModelAndView model, @RequestParam("address") String address, 
			@RequestParam("accId") int accId, @RequestParam("cartId") int cartId) {		
		Account acc = accountService.get(accId);
		Customer customer = customerService.getCustomerFromAccID(accId);
		Cart cart = cartService.getCartFromAcc(accId);
		int billId = billService.createBill(accId, cartId, address);
		Bill bill = billService.get(billId);
		List<CartItems> listItems = cartItemsService.getIteminBill(cart.getId(), billId);
		List<Product> listProduct = cartItemsService.getProdutcInBill(cart.getId(), billId);
		model.addObject("acc", acc);
		model.addObject("cart", cart);
		model.addObject("bill", bill);
		model.addObject("customer", customer);
		model.addObject("listItems", listItems);
		model.addObject("listProduct", listProduct);
		model.setViewName("showBill");
		return model;
		
	}
	
}
