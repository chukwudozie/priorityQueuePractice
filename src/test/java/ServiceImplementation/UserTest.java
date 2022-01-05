package ServiceImplementation;

import Enums.Position;
import Model.Book;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    User teacher = new User("Emeka",Position.TEACHER);
    User jStudent = new User("Ikechukwu",Position.JUNIOR_STUDENT);


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        User teacher = new User("Emeka",Position.TEACHER);
        User jStudent = new User("Ikechukwu",Position.JUNIOR_STUDENT);

    }




    @org.junit.jupiter.api.Test
    void requestForBook() {

        user= new User("Christian", Position.JUNIOR_STUDENT);
        Book book1 = new Book("Biolgy","Emeka",4);

        final String expectedOutput = "Book not available";

        final String actualOutput = user.requestForBook(book1);

        assertEquals(expectedOutput, actualOutput);
    }
}