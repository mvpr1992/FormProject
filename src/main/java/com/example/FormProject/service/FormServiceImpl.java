package com.example.FormProject.service;


import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.FormProject.model.Form;
import com.example.FormProject.repo.FormRepo;


@Service("customerService")
public class FormServiceImpl implements FormService {

	protected static final Logger logger = Logger.getLogger(FormServiceImpl.class.getName());
    private FormRepo formRepo;

    @Autowired
    public FormServiceImpl(FormRepo formRepo) {   
        this.formRepo = formRepo;
    }

    @Override
    public String addCustomer(Form form) throws Exception {
    	String str = formRepo.addCustomer(form);
    	return str;
    }
    
    @Override
    public Form findbyId(int id) throws Exception {
    	 logger.info("In customer service : findbyCustomerId mehtod: customerId : " + id);
    	 return formRepo.findbyCustomerId(id);
    }
    
}