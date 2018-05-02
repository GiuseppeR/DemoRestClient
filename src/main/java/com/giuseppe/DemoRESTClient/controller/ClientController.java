package com.giuseppe.DemoRESTClient.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.giuseppe.DemoRESTClient.model.Customer;

@Controller(value = "controller")
@RequestMapping(path = "/demoClient")
public class ClientController {

	private final Logger log = LogManager.getLogger(ClientController.class);

	@RequestMapping(path = "/mainView")
	public String showMainView() {
		return "mainPage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView insertCustomer(@RequestParam Map<String, String> param) {

		log.info("Inside ClientController - insertCustomer");

		RestTemplate rest = new RestTemplate();

		Customer newCustomer = new Customer();
		newCustomer.setFirstName(param.get("firstName"));
		newCustomer.setLastName(param.get("lastName"));
		newCustomer.setAge(Integer.valueOf(param.get("age")));

		Map<String, Customer> map = new HashMap<>();
		Customer returnedCustomer = rest.postForObject("http://localhost:8080/DemoREST/customer", newCustomer,
				Customer.class);

		map.put("customer", returnedCustomer);

		return new ModelAndView("detailPage", map);
	}

	@RequestMapping(method = RequestMethod.POST, params="_method=put")
	public ModelAndView modifyCustomer(@RequestParam Map<String, String> param) {

		log.info("Inside ClientController - modifyCustomer");

		RestTemplate rest = new RestTemplate();

		Customer modifiedCustomer = new Customer();
		modifiedCustomer.setId(Integer.valueOf(param.get("id")));
		modifiedCustomer.setFirstName(param.get("firstName"));
		modifiedCustomer.setLastName(param.get("lastName"));
		modifiedCustomer.setAge(Integer.valueOf(param.get("age")));

		Map<String, Customer> map = new HashMap<>();
		rest.put("http://localhost:8080/DemoREST/customer", modifiedCustomer, Customer.class);

		map.put("customer", modifiedCustomer);

		return new ModelAndView("detailPage", map);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getCustomerListJson() {

		log.info("Inside ClientController - getCustomerListJson");

		Map<String, List<Customer>> modelMap = new HashMap<>();

		RestTemplate rest = new RestTemplate();
		List<Customer> customerList = new ArrayList<>();
		customerList = rest.getForObject("http://localhost:8080/DemoREST/customer", customerList.getClass());

		modelMap.put("list", customerList);

		log.info(customerList);

		return new ModelAndView("listPage", modelMap);
	}

	@RequestMapping(method = RequestMethod.GET, params = "id")
	public ModelAndView getSingleCustomerJson(@RequestParam("id") long id) {

		log.info("Inside ClientController - getSingleCustomerJson");

		Map<String, Long> params = new HashMap<>();
		params.put("id", id);

		RestTemplate rest = new RestTemplate();
		Customer customer = rest.getForObject("http://localhost:8080/DemoREST/customer?id={id}", Customer.class,
				params);
		Map<String, Customer> modelMap = new HashMap<>();
		modelMap.put("customer", customer);

		return new ModelAndView("detailPage", modelMap);
	}

	@RequestMapping(method = RequestMethod.POST, params = "_method=delete")
	public ModelAndView deleteCustomer(@RequestParam("id") long id) {

		log.info("Inside ClientController - deleteCustomer");
		
		Map<String, Long> params = new HashMap<>();
		params.put("id", id);
		
		RestTemplate rest = new RestTemplate();
		
		Customer deletedCustomer = rest.getForObject("http://localhost:8080/DemoREST/customer?id={id}", Customer.class,
				params);
		Map<String, Customer> modelMap = new HashMap<>();
		modelMap.put("customer", deletedCustomer);
		
		rest.delete("http://localhost:8080/DemoREST/customer?id={id}", id);

		return new ModelAndView("detailPage", modelMap);
	}
}
