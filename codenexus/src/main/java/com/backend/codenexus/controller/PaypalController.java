package com.backend.codenexus.controller;

import com.backend.codenexus.entity.AccessPass;

import com.backend.codenexus.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaypalController {

    @Autowired
    PaypalService service;

    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";

    @GetMapping("/checkout")
    public String home() {
        return "checkout";
    }

    // This is a Java method that handles a POST request made to the "/pay" endpoint of the web
    @PostMapping("/pay")
    public String payment(@ModelAttribute("pass") AccessPass accessP) throws PayPalRESTException {

            Payment payment = service.processPayment(accessP.getPrice(), accessP.getCurrency(), accessP.getMethod(),
                    accessP.getIntent(), accessP.getDescription(), "http://localhost:8484/" + CANCEL_URL,
                    "http://localhost:8484/" + SUCCESS_URL);
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return "redirect:"+link.getHref();
                }
            }
        return "redirect:/";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    /* This is a controller method for handling a successful PayPal payment.
    The method takes in the paymentId and PayerID as request parameters and uses the PayPal service to make the payment. */
    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) throws PayPalRESTException {

            Payment payment = service.makePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                return "success";
            }
        return "redirect:/";
    }

}
