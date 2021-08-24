package shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.model.Account;
import shop.model.Cart;
import shop.model.Customer;
import shop.service.AccountService;
import shop.service.CartService;
import shop.service.CustomerService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/logout")
	public ModelAndView Logout(ModelAndView model) {
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView model) {
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView register(ModelAndView model) {
		model.setViewName("register");
		return model;
	}

	// Them , sua, xoa Account
	@RequestMapping(value = "/newAccount", method = RequestMethod.GET)
	public ModelAndView newAccount(ModelAndView model) {
		Account newAccount = new Account();
		model.addObject("account", newAccount);
		model.setViewName("account_form");
		return model;
	}

	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public ModelAndView saveAccount(@ModelAttribute Account account) {
		if (account.getId() == null) {
			accountService.save(account);
		} else {
			accountService.update(account);
		}

		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping(value = "/editAccount", method = RequestMethod.GET)
	public ModelAndView editAccount(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Account account = accountService.get(id);

		ModelAndView model = new ModelAndView("account_form");

		model.addObject("account", account);

		return model;
	}

	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public ModelAndView deleteAccount(@RequestParam Integer id) {
		accountService.delete(id);
		return new ModelAndView("redirect:/admin");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(ModelAndView model , @RequestParam("name") String name, 
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam("address") String address, @RequestParam("username") String username,
			@RequestParam("password") String password) {
			
			Account acc = new Account(username, password, "customer", true);
			accountService.save(acc);
			int id = accountService.getId(username);
			Customer cus = new Customer(name, email, phone, address, id);
			double price = 0;
			Cart cart = new Cart(price, id);
			customerService.save(cus);
			cartService.save(cart);
			model.setViewName("login");
		return model;
		
	}
	
	@RequestMapping(value = "/blockAccount", method = RequestMethod.GET)
	public ModelAndView blockAccount(@RequestParam Integer id) {
		accountService.block(id);
		return new ModelAndView("redirect:/admin");
	}
}
