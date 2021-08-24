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

import shop.dao.ProductDAO;
import shop.model.Account;
import shop.model.Product;
import shop.service.AccountService;
import shop.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public ModelAndView ProductDetail(ModelAndView model, @RequestParam Integer id, @RequestParam Integer idp) {
		Account acc = accountService.get(id);
		Product product = productService.get(idp);
		model.addObject("product", product);
		model.addObject("acc", acc);
		model.setViewName("product_detail");
		return model;
	}

// Them , sua, xoa Product
	@RequestMapping(value = "/newProduct", method = RequestMethod.GET)
	public ModelAndView newProduct(ModelAndView model) {
		Product newProduct = new Product();
		model.addObject("product", newProduct);
		model.setViewName("product_form");
		return model;
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute Product product) {
		if (product.getId() == null) {
			productService.save(product);
		} else {
			productService.update(product);
		}

		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Product product = productService.get(id);

		ModelAndView model = new ModelAndView("product_form");

		model.addObject("product", product);

		return model;
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteContact(@RequestParam Integer id) {
		productService.delete(id);
		return new ModelAndView("redirect:/admin");
	}
	
	@RequestMapping(value = "/gucci", method = RequestMethod.GET)
	public ModelAndView getGucci(ModelAndView model, @RequestParam Integer id) {
		List<Product> listPro = productService.getGucci();
		Account acc = accountService.get(id);
		model.addObject("listPro", listPro);
		model.addObject("acc", acc);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/8seconds")
	public ModelAndView get8seconds(ModelAndView model, @RequestParam Integer id) {
		List<Product> listPro = productService.get8seconds();
		Account acc = accountService.get(id);
		model.addObject("listPro", listPro);
		model.addObject("acc", acc);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/shanghai")
	public ModelAndView getshanghai(ModelAndView model, @RequestParam Integer id) {
		List<Product> listPro = productService.getShanghai();
		Account acc = accountService.get(id);
		model.addObject("listPro", listPro);
		model.addObject("acc", acc);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/getAllItems")
	public ModelAndView getAllItems(ModelAndView model, @RequestParam Integer id) {
		List<Product> listPro = productService.list();
		Account acc = accountService.get(id);
		model.addObject("listPro", listPro);
		model.addObject("acc", acc);
		model.setViewName("home");
		return model;
	}
	

}
