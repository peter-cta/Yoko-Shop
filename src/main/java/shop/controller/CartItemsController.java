package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.model.Account;
import shop.model.Cart;
import shop.model.CartItems;
import shop.model.Product;
import shop.service.AccountService;
import shop.service.CartItemsService;
import shop.service.CartService;
import shop.service.ProductService;

@Controller
public class CartItemsController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CartItemsService cartItemsService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/checkout")
	public ModelAndView checkout(ModelAndView model, @RequestParam Integer id) {
		List<Product> listProduct = cartItemsService.getProdutcInCart(id);
		Account acc = accountService.get(id);
		Cart cart = cartService.getCartFromAcc(id);
		List<CartItems> listItems = cartItemsService.getIteminCart(cart.getId());
		model.addObject("acc", acc);
		model.addObject("cart", cart);
		model.addObject("listProduct", listProduct);
		model.addObject("listItems", listItems);
		model.setViewName("shopping-cart");
		return model;
	}
	
	@RequestMapping(value = "/addToCart")
	public ModelAndView addToCart(ModelAndView model, @RequestParam Integer id,  @RequestParam Integer idp) {
		Account acc = accountService.get(id);
		Cart cart = cartService.getCartFromAcc(id);
		CartItems ci = new CartItems(1, 0, cart.getId(), idp);
		cartItemsService.addToCart(ci);
		List<Product> listProduct = cartItemsService.getProdutcInCart(id);	
		List<CartItems> listItems = cartItemsService.getIteminCart(cart.getId());
		cart = cartService.getCartFromAcc(id);
		model.addObject("acc", acc);
		model.addObject("cart", cart);
		model.addObject("listProduct", listProduct);
		model.addObject("listItems", listItems);
		model.setViewName("shopping-cart");
		return model;
	}
	
	@RequestMapping(value = "/deleteInCart")
	public ModelAndView deleteInCart(ModelAndView model, @RequestParam Integer id, @RequestParam Integer idp) {
		Account acc = accountService.get(id);
		cartItemsService.deleteItems(idp);
		List<Product> listProduct = cartItemsService.getProdutcInCart(id);
		Cart cart = cartService.getCartFromAcc(id);
		List<CartItems> listItems = cartItemsService.getIteminCart(cart.getId());
		model.addObject("acc", acc);
		model.addObject("cart", cart);
		model.addObject("listProduct", listProduct);
		model.addObject("listItems", listItems);
		model.setViewName("shopping-cart");
		return model;
	}
	
	@RequestMapping(value = "/reduceQty")
	public ModelAndView reduceQty(ModelAndView model, @RequestParam Integer id, @RequestParam Integer idci) {		
		cartItemsService.reduceQty(idci);
		Cart cart = cartService.getCartFromAcc(id);
		Account acc = accountService.get(id);
		List<Product> listProduct = cartItemsService.getProdutcInCart(id);
		List<CartItems> listItems = cartItemsService.getIteminCart(cart.getId());
		cart = cartService.getCartFromAcc(id);
		model.addObject("acc", acc);
		model.addObject("cart", cart);
		model.addObject("listProduct", listProduct);
		model.addObject("listItems", listItems);
		model.setViewName("shopping-cart");
		return model;
	}
	
	@RequestMapping(value = "/increaseQty")
	public ModelAndView increaseQty(ModelAndView model, @RequestParam Integer id, @RequestParam Integer idci) {
		cartItemsService.increaseQty(idci);
		Cart cart = cartService.getCartFromAcc(id);
		Account acc = accountService.get(id);
		List<Product> listProduct = cartItemsService.getProdutcInCart(id);		
		List<CartItems> listItems = cartItemsService.getIteminCart(cart.getId());
		cart = cartService.getCartFromAcc(id);
		model.addObject("acc", acc);
		model.addObject("cart", cart);
		model.addObject("listProduct", listProduct);
		model.addObject("listItems", listItems);
		model.setViewName("shopping-cart");
		return model;
	}
	
	
}
