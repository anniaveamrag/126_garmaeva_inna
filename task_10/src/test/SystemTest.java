package test;

import core.DocumentBook;
import core.TypeOfPaymentDoc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SystemTest extends Assertions {
    @Test
    public void create_CreateEmptyDocBook_DocCountEqualsZero(){
        DocumentBook documentBook = DocumentBook.create();
        assertEquals(0,documentBook.getDocCount());
    }
    @Test
    public void addDoc_addDocWithNumberAndDate_DocCountEqualsOne(){
        DocumentBook documentBook = DocumentBook.create();
        documentBook.addDoc("Номер","Дата");
        assertEquals(1,documentBook.getDocCount());
    }
    @Test
    public void addDoc_addDocWithNullNumber_ThrowsException(){
        DocumentBook documentBook = DocumentBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> documentBook.addDoc(null,"date"));
        assertTrue(exc.getMessage().toLowerCase().contains("Номер документа должен содержать цифры"));
    }
    @Test
    public void addDoc_addDocWithNullDate_ThrowsException(){
        DocumentBook documentBook = DocumentBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> documentBook.addDoc("number",null));
        assertTrue(exc.getMessage().toLowerCase().contains("Укажите правильную дату"));
    }

    @Test
    public void addDoc_addDocWithNullNumberAndNullDate_ThrowsException(){
        DocumentBook documentBook = DocumentBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> documentBook.addDoc(null,null));
        assertTrue(exc.getMessage().toLowerCase().contains("Номер документа должен содержать цифры") &&
                exc.getMessage().toLowerCase().contains("Укажите правильную дату"));
    }
    @Test
    public void registerPaymentDoc_registerPayDocWithoutData_PaymentDocCountEqualsZero(){
        DocumentBook documentBook = DocumentBook.create();

        documentBook.addDoc("Номер","Дата");
        assertEquals(0,documentBook.getDocs().get("Номер").getPaymentDocCount());
    }
    @Test
    public void registerPaymentDoc_registerPayDocWithData_PaymentDocCountEqualsOne(){
        DocumentBook documentBook = DocumentBook.create();

        documentBook.addDoc("Номер","Дата");
        documentBook.registerPaymentDoc(100, 1, "Номер", TypeOfPaymentDoc.BankOrder, "20000101");
        assertEquals(1,documentBook.getDocs().get("Номер").getPaymentDocCount());
    }
    @Test
    public void registerPaymentDoc_registerPayDocWithData_PaymentDocCountEqualsThree(){
        DocumentBook documentBook = DocumentBook.create();

        documentBook.addDoc("Номер","Дата");
        documentBook.registerPaymentDoc(100, 1, "Номер", TypeOfPaymentDoc.PaymentOrder, "20220202");
        documentBook.registerPaymentDoc(200, 2, "Номер", TypeOfPaymentDoc.PaymentOrder, "20220303");
        documentBook.registerPaymentDoc(300, 3, "Номер", TypeOfPaymentDoc.BankOrder, "20220404");
        assertEquals(3,documentBook.getDocs().get("Номер").getPaymentDocCount());
    }
    @Test
    public void registerPaymentDoc_registerPayDocWithSumLessThenZero_TrowsException(){
        DocumentBook documentBook = DocumentBook.create();
        documentBook.addDoc("Номер","Дата");

        var exc = assertThrows(IllegalArgumentException.class, () ->
                documentBook.registerPaymentDoc(-100, 1, "Номер", TypeOfPaymentDoc.PaymentOrder, "20220202"));
        assertTrue(exc.getMessage().toLowerCase().contains("Сумма должна быть положительной"));
    }
    @Test
    public void registerPaymentDoc_registerPayDocWithPaymentDocNumberLessThenZero_TrowsException(){
        DocumentBook documentBook = DocumentBook.create();
        documentBook.addDoc("Номер","Дата");

        var exc = assertThrows(IllegalArgumentException.class, () ->
                documentBook.registerPaymentDoc(100, -7, "Номер", TypeOfPaymentDoc.PaymentOrder, "20220202"));
        assertTrue(exc.getMessage().toLowerCase().contains("Номер документа должен быть положительным"));
    }
    @Test
    public void getList_getListOfAllPayments_equalLists(){
        DocumentBook documentBook = DocumentBook.create();
        documentBook.addDoc("Номер","Дата");
        documentBook.registerPaymentDoc(100, 1, "Номер", TypeOfPaymentDoc.PaymentOrder, "20220202");
        documentBook.registerPaymentDoc(500, 2, "Номер", TypeOfPaymentDoc.BankOrder, "20220202");
        documentBook.registerPaymentDoc(300, 3, "Номер", TypeOfPaymentDoc.PaymentOrder, "20220202");
        documentBook.addDoc("Номер2","Дата");
        documentBook.registerPaymentDoc(400, 1, "Номер2", TypeOfPaymentDoc.PaymentOrder, "20220202");
        documentBook.registerPaymentDoc(700, 2, "Номер2", TypeOfPaymentDoc.BankOrder, "20220202");
        documentBook.registerPaymentDoc(800, 3, "Номер2", TypeOfPaymentDoc.PaymentOrder, "20220202");
        List<Integer> paymentDocs = new ArrayList();
        paymentDocs.add(100);
        paymentDocs.add(500);
        paymentDocs.add(300);
        paymentDocs.add(400);
        paymentDocs.add(700);
        paymentDocs.add(800);
        assertArrayEquals(paymentDocs.toArray(),documentBook.getAllPayments().toArray());
    }
    @Test
    public void deletePaymentDoc_DeletePaymentDocWithDocNumberNumberAndDate_PaymentDocCountEqualsZero(){
        DocumentBook documentBook = DocumentBook.create();
        documentBook.addDoc("Номер","20220101");
        documentBook.registerPaymentDoc(100,2, "Номер", TypeOfPaymentDoc.PaymentOrder,"20220505");
        documentBook.registerPaymentDoc(100,1, "Номер", TypeOfPaymentDoc.PaymentOrder,"20220606");
        documentBook.deletePayment( "Номер", 2, "20220505");
        documentBook.deletePayment( "Номер", 1, "20220606");
        assertEquals(0, documentBook.getDocs().get("Номер").getPaymentDocCount());
    }
    @Test
    public void deletePaymentDoc_DeleteNonExistentPaymentDoc_EqualsOne(){
        DocumentBook documentBook = DocumentBook.create();
        documentBook.addDoc("Номер","20220101");
        documentBook.registerPaymentDoc(100,2, "Номер", TypeOfPaymentDoc.PaymentOrder,"20220505");
        documentBook.deletePayment( "Номер", 1, "20220606");
        assertEquals(1, documentBook.getDocs().get("Номер").getPaymentDocCount());
    }
    @Test
    public void getGeneralSum_CalculateDocGeneralSumOfPayments_GeneralSumEquals400(){
        DocumentBook documentBook = DocumentBook.create();
        documentBook.addDoc("123","20220707");
        documentBook.registerPaymentDoc(300,101,"123", TypeOfPaymentDoc.BankOrder, "20220808");
        documentBook.registerPaymentDoc(100,102,"123", TypeOfPaymentDoc.BankOrder, "20220909");
        assertEquals(400, documentBook.getDocs().get("123").getSumOfPayments());
    }
    @Test
    public void getListOfPayments_GetAllPaymentsFromDoc_EqualLists(){
        DocumentBook documentBook = DocumentBook.create();
        documentBook.addDoc("123","20220707");
        documentBook.registerPaymentDoc(200,101,"123", TypeOfPaymentDoc.BankOrder, "20220808");
        documentBook.registerPaymentDoc(100,102,"123", TypeOfPaymentDoc.BankOrder, "20220909");
        documentBook.addDoc("321","20220707");
        documentBook.registerPaymentDoc(500,101,"321", TypeOfPaymentDoc.BankOrder, "20220808");
        documentBook.registerPaymentDoc(400,102,"321", TypeOfPaymentDoc.BankOrder, "20220909");
        List<Integer> sums = new ArrayList();
        sums.add(200);
        sums.add(100);
        assertArrayEquals(sums.toArray(), documentBook.getDocs().get("123").getListOfPayments().toArray());
    }
}
