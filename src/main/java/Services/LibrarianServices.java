package Services;

import Exceptions.LibraryException;
import Model.Book;
import Model.Person;
import ServiceImplementation.User;

public interface LibrarianServices {

    public void registerUser(User person);
    public String addBookToLibrary(Book book);
    public String lendBookToUser(Person person, Book book, Integer copiesOfBook) throws LibraryException;

//    void lendBookToUserByPriority();
    public String collectBookFromUser(Person person, String bookTitle) ;

//    void lendBookToUser()
}
