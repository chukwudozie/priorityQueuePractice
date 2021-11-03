package ServiceImplementation;

import Enums.Position;
import Model.Book;
import Model.Library;
import Model.Person;
import Services.UserServices;

public class User extends Person implements UserServices,Comparable<Person>{


    public User(String fName, Position position){
        super(fName,position);
    }

    @Override
    public int compareTo(Person o) {
        return getPriority() < o.getPriority() ? 1 : -1;
    }


//    @Override
//    public String returnBook(Book book, Person person) {
//        return null;
//    }
//
    @Override
    public String requestForBook(Book book) {
        if(Library.getAvailableBooks().containsKey(book.getBookTitle()) && book.getNumberOfBooks() != 0){
           return this.getFirstName()+", you can borrow "+book.getBookTitle();
        } else
            return "Book not available";
    }

}
