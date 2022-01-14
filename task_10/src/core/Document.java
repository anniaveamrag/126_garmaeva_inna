package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Document { private String date;
    private HashMap<Integer, PaymentDoc> paymentDocs;

    public Document(String date){
        this.date = date;
        paymentDocs = new HashMap<>();
    }
    public void registerPaymentDoc(int sum1, int number, TypeOfPaymentDoc type, String date){
        paymentDocs.put(number,new PaymentDoc(sum1, type, date));
    }

    public int getPaymentDocCount() {
        return paymentDocs.size();
    }

    public HashMap<Integer, PaymentDoc> getPaymentDocuments(){
        return paymentDocs;
    }

    public int getSumOfPayments() {
        int sum = 0;
        for(PaymentDoc doc : paymentDocs.values()){
            sum += doc.getSum();
        }
        return sum;
    }
    public List<Integer> getListOfPayments() {
        List<Integer> payments = new ArrayList();
        for(PaymentDoc paymentDoc : paymentDocs.values()){
            payments.add(paymentDoc.getSum());
        }
        return payments;
    }
}
