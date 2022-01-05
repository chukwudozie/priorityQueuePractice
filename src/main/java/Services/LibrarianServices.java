package Services;

import Exceptions.LibraryException;
import Model.Book;
import Model.Person;

public interface LibrarianServices {
//     Consumer<Person> addToReg = (person) -> {
//          Queue<Person> personQueue = new LinkedList<>();
//          if(!personQueue.contains(person)){
//               personQueue.add(person);
//          }
//          if(!priorityQueue.contains(person)){
//               priorityQueue.add(person);
//          }
//          count++;
//     };
     void registerUser(Person person);
     String addBookToLibrary(Book book);
     String lendBookToUserByPriority(Book book) throws LibraryException;
     String lendBookToUserByFifo(Book book) throws LibraryException;
     String collectBookFromUser(Person person, String bookTitle) ;


}
