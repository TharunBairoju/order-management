/**
 * 
 */
package com.ordermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagement.command.order.AddProductsToCartCommand;
import com.ordermanagement.command.order.CheckoutCartCommand;
import com.ordermanagement.command.order.FetchCartDetailsCommand;
import com.ordermanagement.command.order.UpdateCartCommand;
import com.ordermanagement.constants.Constants;
import com.ordermanagement.request.AddToCartRequest;
import com.ordermanagement.request.UpdateCartRequest;
import com.ordermanagement.response.Response;

/**
 * Mar 29, 2020
 *
 *	@author Tharunkumar Bairoju
 * 
 */
@RestController
@RequestMapping(value = "/api/shoppingcart")
public class ShoppingCartController {
	
	@Autowired
	AddProductsToCartCommand addProductsToCartCommand;
	
	@Autowired
	FetchCartDetailsCommand fetchCartDetailsCommand;
	
	@Autowired
	CheckoutCartCommand checkoutCartCommand;
	
	@Autowired
	UpdateCartCommand updateCartCommand;
	
	
	
	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	public ResponseEntity<?> addProductsToCart(@RequestBody AddToCartRequest request){
		Response response =  addProductsToCartCommand.execute(request);
		if(response != null) {
			return ResponseEntity.status(200).body(response);
		}
		return ResponseEntity.status(500).body(new Response(Constants.FAILED, "Failed to add product to cart.!", null));
	}
	
	@RequestMapping(value = "/reviewcart", method = RequestMethod.GET)
	public ResponseEntity<?> fetchCartDetails(@RequestParam Long customerId){
		Response response =  fetchCartDetailsCommand.execute(customerId);
		if(response != null) {
			return ResponseEntity.status(200).body(response);
		}
		return ResponseEntity.status(500).body(new Response(Constants.FAILED, "Failed to products from cart.!", null));
	}
	
	
	@RequestMapping(value = "/checkoutcart", method = RequestMethod.PUT)
	public ResponseEntity<?> checkoutCartDetails(@RequestParam Long customerId, @RequestParam Long orderId){
		Response response =  checkoutCartCommand.execute(customerId);
		if(response != null) {
			return ResponseEntity.status(200).body(response);
		}
		return ResponseEntity.status(500).body(new Response(Constants.FAILED, "Failed to products from cart.!", null));
	}
	
	
	@RequestMapping(value = "/modifycart", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCartDetails(@RequestBody UpdateCartRequest request){
		Response response =  updateCartCommand.execute(request);
		if(response != null) {
			return ResponseEntity.status(200).body(response);
		}
		return ResponseEntity.status(500).body(new Response(Constants.FAILED, "Failed to update cart.!", null));
	}
	
	

}
