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
}
