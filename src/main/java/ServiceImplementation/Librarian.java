package ServiceImplementation;

import Enums.Position;
import Exceptions.LibraryException;
import Model.Book;
import Model.Library;
import Model.Person;
import Services.LibrarianServices;

import java.util.*;

public class Librarian extends Person implements LibrarianServices {
    private  static  List<String> registeredUsers = new ArrayList<>();

    private  static Queue<Person> personQueue = new LinkedList<>();

    public static Queue<Person> getPersonQueue() {
        return personQueue;
    }

    public static void setPersonQueue(Queue<Person> personQueue) {
        Librarian.personQueue = personQueue;
    }

    public static Queue<Person> getPriorityQueue() {
        return priorityQueue;
    }

    public static void setPriorityQueue(Queue<Person> priorityQueue) {
        Librarian.priorityQueue = priorityQueue;
    }

    private  static  Queue<Person> priorityQueue = new PriorityQueue<>();
//            (new Comparator<Person>() {
//        @Override
//        public int compare(Person person1, Person person2) {
//
//            if(person1.getPriority()< person2.getPriority()){
//                return -1;
//            }else if(person1.getPriority()> person2.getPriority()){
//                return 1;
//            }else  {
//                return 0;
//            }
//        }
//    });

    public Librarian(String name, Position position){
        super(name, position);
    }

    @Override
    public boolean registerUser(Person person) {
        if (person.getFirstName() != null) {
            if (!personQueue.contains(person)) {
                personQueue.add(person);
                return true;
            }
            if (!priorityQueue.contains(person)) {
                priorityQueue.add(person);
                return true;
            }
        }
        return false;
    }

    @Override
    public String addBookToLibrary(Book book){
        if(Library.getAvailableBooks().containsKey(book.getBookTitle())) {
            return "Book is already in the Library";

        }else{
            Library.getAvailableBooks().put(book.getBookTitle(), book.getNumberOfBooks());
            return book.getNumberOfBooks()+" copy of "+book.getBookTitle()+ " added successfully";
        }
    }


    @Override
    public String lendBookToUser(Person person, Book book, Integer copiesOfBook) throws LibraryException {
        if(Library.getAvailableBooks().containsKey(book.getBookTitle()) && copiesOfBook != 0){
            Integer copiesAvailable = Library.getAvailableBooks().get(book.getBookTitle());
            if(copiesAvailable != 0){
//                if(registerUser(person)) {
//                    person = personQueue.remove();
//
//                }
                Map<String, Integer> borrowedBooks = new HashMap<>();
                if(copiesOfBook < copiesAvailable){
                    borrowedBooks.put(book.getBookTitle(),copiesOfBook);
                    person.setBooksBorrowed(borrowedBooks);
                    Library.getAvailableBooks().put(book.getBookTitle(),copiesAvailable-copiesOfBook);
                    return copiesOfBook+" copies of the book "+book.getBookTitle()+
                            " successfully borrowed out to "+person.getFirstName();
                } else{
                    borrowedBooks.put(book.getBookTitle(),1);//books demanded exceeds number available, borrow only one
                    person.setBooksBorrowed(borrowedBooks);
                    Library.getAvailableBooks().put(book.getBookTitle(),copiesAvailable-1);
                    return "Only one copy of the book "+book.getBookTitle()+" is borrowed to "+person.getFirstName();
                }
            } else throw new LibraryException("No copy of the book in the library");
//                return "Sorry, this book is not available at the moment "+person.getFirstName()+", come back later";
        } else return
                "Sorry "+person.getFirstName()+ " the book, "+book.getBookTitle()+ " is not in our Library";

    }

//    @Override
//    public void lendBookToUserByPriority() {
//
//        if(priorityQueue != null){
//
//            Person borrower = priorityQueue.remove();
//
//            System.out.printf("%nBook given To:  %s ", borrower.getFirstName());
//
//        }
//
//    }


    @Override
    public String collectBookFromUser(Person person, String bookTitle) {
        Map<String,Integer> borrowedBooks = person.getBooksBorrowed();
        if(borrowedBooks.containsKey(bookTitle)){
            Integer numberOfBorrowedBooks = borrowedBooks.get(bookTitle);
            Library.getAvailableBooks().put(bookTitle,Library.getAvailableBooks().get(bookTitle)+numberOfBorrowedBooks);
            borrowedBooks.remove(bookTitle);
            return "Tbe book "+bookTitle+ " has been returned to the library by "+person.getFirstName();

        }else
            return "This book has not been borrowed by "+person.getFirstName();
    }

}
