package shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import shop.dao.AccountDAO;
import shop.dao.BrandDAO;
import shop.dao.CustomerDAO;
import shop.dao.ProductDAO;
import shop.model.Account;
import shop.model.Bill;
import shop.model.Brand;
import shop.model.Customer;
import shop.model.Product;
import shop.service.AccountService;
import shop.service.BillService;
import shop.service.BrandService;
import shop.service.CustomerService;
import shop.service.ProductService;

@RestController
public class MainController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private BillService billService;
	
	@RequestMapping(value = "/")
	public ModelAndView Login(ModelAndView model) {
		List<Product> listPro = productService.list();
		List<Brand> listBrand = brandService.list();
		model.addObject("listPro", listPro);
		model.addObject("listBrand", listBrand);
		model.addObject("status", "notlogin");
		model.setViewName("homeBlank");
		return model;
	}
	
	
	
	

	@RequestMapping(value = "/admin")
	public ModelAndView admin(ModelAndView model, @ModelAttribute Account acc) {
		List<Account> listAcc = accountService.list();
		List<Product> listPro = productService.list();
		List<Customer> listCus = customerService.list();
		List<Brand> listBrand = brandService.list();
		List<Bill> listBill = billService.list();
		List<Customer> lisCustomers = billService.getListCustomerFromBill(listBill);
		List<List> listProductInBill = billService.getListProductInBill(listBill);
		List<List> listCartItemsInBill = billService.getListCartItemsInBill(listBill);
		model.addObject("listAcc", listAcc);
		model.addObject("listPro", listPro);
		model.addObject("listCus", listCus);
		model.addObject("listBrand", listBrand);
		model.addObject("listBill", listBill);
		model.addObject("lisCustomers", lisCustomers);
		model.addObject("listProductInBill", listProductInBill);
		model.addObject("listCartItemsInBill", listCartItemsInBill);
		model.addObject("acc", acc);
		model.setViewName("admin");
		return model;
	}
	
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView listContact(ModelAndView model , @RequestParam("username") String username, @RequestParam("password") String password) {

		Account acc = accountService.login(username, password);
		if(acc!=null && acc.getEnable() == true) {	
			if(acc.getPosition().equals("admin")) {
				return new ModelAndView("redirect:/admin");
			}else if(acc.getPosition().equals("customer")) {
				List<Product> listPro = productService.list();
				model.addObject("listPro", listPro);
				model.addObject("acc", acc);
				model.setViewName("home");
				return model;
			}
		}
		model.setViewName("login");
		return model;
		
	}
	
	@RequestMapping(value = "/backToShop")
	public ModelAndView backToShop(ModelAndView model, @RequestParam Integer id) {
		Account acc = accountService.get(id);
		List<Product> listPro = productService.list();
		List<Brand> listBrand = brandService.list();
		model.addObject("listPro", listPro);
		model.addObject("acc", acc);
		model.setViewName("home");
		return model;
	}
	
}
