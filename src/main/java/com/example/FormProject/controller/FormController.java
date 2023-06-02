package com.example.FormProject.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.FormProject.model.Form;
import com.example.FormProject.service.FormService;

@RestController
@RequestMapping("/customers")
public class FormController {

    
    protected static final Logger logger = Logger.getLogger(FormController.class.getName());
    protected FormService formService;

    /**
     *
     * @param customerService
     */
    @Autowired
    public FormController(FormService formService) {
        this.formService = formService;
    }
    
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Form> findByCustomerId(@PathVariable("id") int id) {
       
        Form form;
        try {
        	form = formService.findbyId(id);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised findByUserId REST Call {0}", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return form != null ? new ResponseEntity<>(form, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    @GetMapping(path = "/{firstName}/{lastName}/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String addCustomer(@PathVariable("firstName") String firstName,
    		@PathVariable("lastName") String lastName, 
    		@PathVariable("address") String address) {
    	
        Form form = new Form();
        
        form.setFirstName(firstName);
        form.setLastName(lastName);
        form.setAddress(address);
        
        String str = null;
        try {
        	str = formService.addCustomer(form);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised findByUserId REST Call {0}", ex);   
        }
        return str;
    }
}