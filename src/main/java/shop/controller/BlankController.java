package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.model.Account;
import shop.model.Brand;
import shop.model.Product;
import shop.service.ProductService;

@Controller
public class BlankController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/productDetailbl", method = RequestMethod.GET)
	public ModelAndView ProductDetail(ModelAndView model, @RequestParam Integer idp) {
		Product product = productService.get(idp);
		model.addObject("product", product);
		model.setViewName("productDetailBlank");
		return model;
	}
	
	@RequestMapping(value = "/guccibl")
	public ModelAndView getGucci(ModelAndView model) {
		List<Product> listPro = productService.getGucci();
		model.addObject("listPro", listPro);
		model.setViewName("homeBlank");
		return model;
	}
	
	@RequestMapping(value = "/8secondsbl")
	public ModelAndView get8seconds(ModelAndView model) {
		List<Product> listPro = productService.get8seconds();
		model.addObject("listPro", listPro);
		model.setViewName("homeBlank");
		return model;
	}
	
	@RequestMapping(value = "/shanghaibl")
	public ModelAndView getshanghai(ModelAndView model) {
		List<Product> listPro = productService.getShanghai();
		model.addObject("listPro", listPro);
		model.setViewName("homeBlank");
		return model;
	}
	
	@RequestMapping(value = "/getAllItemsbl")
	public ModelAndView getAllItems(ModelAndView model) {
		List<Product> listPro = productService.list();
		model.addObject("listPro", listPro);
		model.setViewName("homeBlank");
		return model;
	}
	
	@RequestMapping(value = "/backToShopbl")
	public ModelAndView backToShop(ModelAndView model) {
		List<Product> listPro = productService.list();
		model.addObject("listPro", listPro);
		model.setViewName("homeBlank");
		return model;
	}
	
}
