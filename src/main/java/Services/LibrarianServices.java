package Services;

import Exceptions.LibraryException;
import Model.Book;
import Model.Person;
import ServiceImplementation.User;

public interface LibrarianServices {

     boolean registerUser(Person person);
     String addBookToLibrary(Book book);
     String lendBookToUser(Person person, Book book, Integer copiesOfBook) throws LibraryException;

//    void lendBookToUserByPriority();
     String collectBookFromUser(Person person, String bookTitle) ;

//    void lendBookToUser()
}
