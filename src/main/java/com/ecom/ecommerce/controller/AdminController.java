package com.ecom.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * This class is created to test security config.
 * No actual end-points have been added yet.
 *
 * It is part of the e-commerce backend service.
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/getAdmin")
    public String getAdmin() {
        return "This is Admin.";
    }
}
