package fm.vane.spb1.demo1.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import fm.vane.spb1.demo1.model.Customer;

// @RestController
// @RequestMapping("rest")

public class RootController {

    @RequestMapping("/iii")
    public String index(Model model) {
        return "index";
    }    

    @RequestMapping("/articles")
    public ModelAndView displayArticle() {

        Map<String, Object> model = new HashMap<>();
        List<Customer> customers = generateDummyCustomers();
        model.put("customers", customers);
        return new ModelAndView("cus", model);
    }

    private List<Customer> generateDummyCustomers() {
        return List.of(
            new Customer("c1","c2"),
            new Customer("c3","c4"),
            new Customer("c5","c6")
        );
    }

    //This logger replaces System.out.print()
    private static final Logger log = LoggerFactory.getLogger(RootController.class);
    
    /**
     * Example
     * This tells spring this function is a route for a request to "/" of type GET
     * @return simple "hello world" returned on path "/"
     */
    @RequestMapping(value="/helloworld", method=RequestMethod.GET)
    public String hello() {
        // The response will include the return value
        return "Hello World.";
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public RedirectView login(RedirectAttributes attributes) {
        // attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectAttributes");
        attributes.addAttribute("attribute", "redirectWithRedirectAttributes");
        return new RedirectView("/");
    }

    /**
     * Automatic serialization from object (entity) to JSON
     * @return Customer object, that gets translated into JSON
     */
    @GetMapping("/customer")
    public Customer greetCustomer(){
        return new Customer("John", "Doe");
    }
    
    /**
     * this is where SpringFramework injects an object that connects to the DB and executes operations for us
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * PART 1, CREATE TABLE AND ADD SOME DATA
     * @return confirmation message
     */
    @GetMapping("/addSomeCustomers")
    public String addCustomers(){
        
        log.info("Creating tables from scratch, the first time"); //Log to the console
        // String with the SQL for creating the table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS customers(" +
            "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))"); 
        // Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
            .map(name -> name.split(" "))
            .collect(Collectors.toList()); // Java way of splitting First and Last name, not important here!
        // Use a Java 8 stream to print out each tuple of the list
        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
        return "4 customers added to db";
    }
    
    /**
     * PART 2, QUERY THE DATA
     * @return list of customers found in the customers table
     */
    @GetMapping("/customers")
    public List<Customer> findAllCustomers(){
        log.info("Querying for customer records");
        // Create select
        String SELECT_FOR_NAME_2 = "SELECT id, first_name, last_name FROM customers";
        // Excecute select against a list of maps of pairs of string / object
        List<Map<String, Object>> result = jdbcTemplate.queryForList(SELECT_FOR_NAME_2);
        // Create empty result list
        ArrayList<Customer> resultList =  new ArrayList<Customer>();
        // Create a list of Customers from the result list
        for (Map<String,Object> map : result) {
            Object fname = map.get("first_name");
            Object lname = map.get("last_name");
            resultList.add(new Customer(fname.toString(), lname.toString()));
        }
        // Return the list that will be serialized automatically to JSON
        return resultList;
    }
}
