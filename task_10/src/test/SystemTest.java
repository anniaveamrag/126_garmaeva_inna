package test;

import core.DocumentBook;
import core.TypeOfPaymentDoc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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


}
