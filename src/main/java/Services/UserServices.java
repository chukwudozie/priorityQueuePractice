package Services;

import Exceptions.LibraryException;
import Model.Book;
import Model.Person;

public interface UserServices {


    public String requestForBook(Book book) throws LibraryException;
//    public String borrowBook(Book book, Person user);



}
