package com.backend.codenexus.service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
@Service
public class PaypalService {

    @Autowired
    private APIContext paypalReq;
    public Payment processPayment(Double price, String currency, String method, String intent,
                                  String productDes, String payCancel, String paySucc) throws PayPalRESTException {
        Amount fee = new Amount();
        price = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP).doubleValue();
        fee.setTotal(String.format("%.2f", price));
        fee.setCurrency(currency);

        Transaction tempTransaction = new Transaction();
        tempTransaction.setAmount(fee);
        tempTransaction.setDescription(productDes);
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(tempTransaction);

        Payer buyer = new Payer();
        buyer.setPaymentMethod(method.toString());


        Payment tempPay = new Payment();
        tempPay.setIntent(intent.toString());
        tempPay.setPayer(buyer);
        tempPay.setTransactions(transactionList);


        //Need to set the redirect urls for tempPay otherwise you get a white label error
        RedirectUrls urls = new RedirectUrls();
        urls.setCancelUrl(payCancel);
        urls.setReturnUrl(paySucc);
        tempPay.setRedirectUrls(urls);

        return tempPay.create(paypalReq);
    }

    public Payment makePayment(String paymentID, String payerID) throws PayPalRESTException {
        Payment tempPayment = new Payment();
        tempPayment.setId(paymentID);

        PaymentExecution executePay = new PaymentExecution();
        executePay.setPayerId(payerID);

        return tempPayment.execute(paypalReq, executePay);
    }
}