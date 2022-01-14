package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DocumentBook {
    private HashMap<String, Document> data;

    public DocumentBook(){
        data = new HashMap<>();
    }

    public static DocumentBook create(){
        return new DocumentBook();
    }

    public void addDoc(String number, String date){
        StringBuilder error = new StringBuilder();

        if(number == null){
            error.append("Ошибка\n");
        }
        if(date == null){
            error.append("Ошибка\n");
        }
        if(!error.isEmpty()){
            throw new IllegalArgumentException(error.toString());
        }
        if(!data.containsKey(number)){
            data.put(number, new Document(date));
            System.out.println("Документ зарегистрирован");
        }

    }
    public int getDocCount(){
        return data.size();
    }

    public HashMap<String, Document> getDocs(){
        return data;
    }

    public void registerPaymentDoc(int sum, int paymentDocNumber, String docNumber,TypeOfPaymentDoc type, String date) {
        StringBuilder error = new StringBuilder();
        if(sum<0){
            error.append("Ошибка! Введите положительную сумму:\n");

        }
        if(paymentDocNumber<0){
            error.append("Ошибка!\n");
        }
        if(docNumber == null){
            error.append("Ошибка!\n");
        }
        if(date == null){
            error.append("Ошибка!\n");
        }
        if(data.get(docNumber)==null){
            error.append("Ошибка! Платежный документ не найден\n");
        }
        if(!error.isEmpty()){
            throw new IllegalArgumentException(error.toString());
        }
        else {
            data.get(docNumber).registerPaymentDoc(sum, paymentDocNumber, type, date);
            System.out.println("Платежный документ успешно создан");

        }
    }
    public List<Integer> getAllPayments() {
        List<Integer> payments = new ArrayList();
        for(Document document: data.values()){
            for(PaymentDoc paymentDoc : document.getPaymentDocuments().values())
                payments.add(paymentDoc.getSum());
        }

        return payments;
    }
    public void deletePayment(String docNumber, int paymentDocNumber, String paymentDocDate) {
        StringBuilder error = new StringBuilder();
        if(docNumber == null){
            error.append("Введите номер документа\n");
        }
        if(paymentDocDate == null){
            error.append("Введите дату\n");
        }
        if(!data.get(docNumber).getPaymentDocuments().containsValue(paymentDocNumber)){
            error.append("Ошибка!\n");
        }
        if(!error.isEmpty()){
            throw new IllegalArgumentException(error.toString());
        }

        else {
            data.get(docNumber).getPaymentDocuments().remove(paymentDocNumber);
        }

    }
    public void commandList(){
        System.out.println("1 - Добавление договора");
        System.out.println("2 - Добавление платежного документа");
        System.out.println("3 - Вычисление суммы всех платежей по договору с заданным номером");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        run(command);
    }

    public void run(String command){

        DocumentBook.create();

        Scanner sc = new Scanner(System.in);
        switch (command) {
            case "1":
                System.out.println("Введите номер документа");
                String number = sc.nextLine();
                System.out.println("Введите дату");
                String date = sc.nextLine();
                addDoc(number, date);
                commandList();

            case "2":
                System.out.println("Введите номер договора");
                String numberDoc = sc.nextLine();
                System.out.println("Введите дату");
                String datePay = sc.nextLine();
                System.out.println("Введите cумму");
                int sum = sc.nextInt();
                System.out.println("Введите платежный номер");
                int numberPay = sc.nextInt();
                System.out.println("Тип договора (1 - Платежное поручение, 2 - Банковский ордер)");
                int type = sc.nextInt();
                if(type==1) registerPaymentDoc(sum, numberPay, numberDoc, TypeOfPaymentDoc.PaymentOrder, datePay);
                else if(type==2) registerPaymentDoc(sum, numberPay, numberDoc, TypeOfPaymentDoc.BankOrder, datePay);
                else System.out.println("Неверная команда");
                commandList();
            case "3":
                System.out.println("Введите номер договора");
                String docNumber = sc.nextLine();
                System.out.println(getDocs().get(docNumber).getSumOfPayments());
                commandList();
            default:
                System.out.println("Неверная команда");
        }

    }
}
