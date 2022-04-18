package com.sanki0.place_an_order.process;

import com.sanki0.place_an_order.steps.DoPayment;
import com.sanki0.place_an_order.steps.GenerateOrder;
import com.sanki0.place_an_order.validation.ReserveValidation;
import com.sanki0.place_an_order.validation.UpdateInventoryValidation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Client {
    @RequestMapping()
    public static void main(String[] args) {
        User sanki0 = new User(4200, 400);
        Inventory pc = new Inventory(200, 50);
        PlaceAnOrder project = new PlaceAnOrder(sanki0, pc);

        project.start();

        boolean process;
        String paymentCode = "", orderId = "";

        ReserveValidation reserveValidation = new ReserveValidation(sanki0, pc, 350);
        process = reserveValidation.isValidate();
        project.processed();

        if (process) {
            UpdateInventoryValidation updateInventoryValidation= new UpdateInventoryValidation(sanki0,pc,50);
            process= updateInventoryValidation.isValidate();
            project.processed();
        }

        if (process) {
            ((DoPayment) project.getCurrentStep()).makePayment();
            paymentCode = ((DoPayment) project.getCurrentStep()).getPaymentId().toString();
            project.processed();
            orderId = ((GenerateOrder) project.getCurrentStep()).getOrderId().toString();
        }


        System.out.println("Your order was correctly processed, the validation codes are:\n" +
                "Fund Reserved Code: " + reserveValidation.getReservationCode() + ",\n" +
                "Payment Code: " + paymentCode + ",\n" +
                "Order ID: " + orderId + "");

    }
}
