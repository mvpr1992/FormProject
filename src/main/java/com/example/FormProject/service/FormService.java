package com.example.FormProject.service;

import com.example.FormProject.model.Form;

public interface FormService {

    public String addCustomer(Form form) throws Exception;

    public Form findbyId(int id) throws Exception;
     
}