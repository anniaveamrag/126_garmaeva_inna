package test;

import core.DocumentBook;
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
        documentBook.addDoc("number","date");
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

}
