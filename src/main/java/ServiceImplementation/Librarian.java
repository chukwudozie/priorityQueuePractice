package ServiceImplementation;

import Enums.Position;
import Exceptions.LibraryException;
import Model.Book;
import Model.Library;
import Model.Person;
import Services.LibrarianServices;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Librarian extends Person implements LibrarianServices {
    public int count;
    private  static  List<String> activeUsers = new ArrayList<>(); // List of Users with Book already

    private  static Queue<Person> personQueue = new LinkedList<>();

    public static Queue<Person> getPersonQueue() {return personQueue;}

    public static void setPersonQueue(Queue<Person> personQueue) {Librarian.personQueue = personQueue;}

    public static Queue<Person> getPriorityQueue() {return priorityQueue;}

    public static void setPriorityQueue(Queue<Person> priorityQueue) {Librarian.priorityQueue = priorityQueue;}

    private  static  Queue<Person> priorityQueue = new PriorityQueue<>(new Comparator<Person>() {
        @Override
        public int compare(Person one, Person two) {
            if(one.getPriority() > two.getPriority()){
                return -1;
            }else if(one.getPriority() < two.getPriority()){
                return 1;
            }else{
                return 0;
            }
        }
    });

    public Librarian(String name, Position position){
        super(name, position);
    }

    public int getCount() {
        return count;
    }

    @Override
    public void registerUser(Person person) {
        registerUser2.accept(person);
    }

//    Predicate<Person>che

    private final Consumer<Person> registerUser2 = person -> {
        if(person != null){
            if(!personQueue.contains(person)){
                personQueue.add(person);
            }
            if(!priorityQueue.contains(person)){
                priorityQueue.add(person);
            }
            count++;
        }
    };

    Function<Book, String> addBookToLibrary = book -> {
        if(Library.getAvailableBooks().containsKey(book.getBookTitle())) {
            int old = Library.getAvailableBooks().get(book.getBookTitle());
            Library.getAvailableBooks().put(book.getBookTitle(),old + book.getNumberOfBooks());
            return book.getNumberOfBooks()+" new " +book.getBookTitle()+" added.";
        }else{
            Library.getAvailableBooks().put(book.getBookTitle(), book.getNumberOfBooks());
            return book.getNumberOfBooks()+" copy of "+book.getBookTitle()+ " added successfully";
        }
    };

    @Override
    public String addBookToLibrary(Book book){
        return addBookToLibrary.apply(book);
    }


    @Override
    public String lendBookToUserByPriority(Book book) throws LibraryException {
        if(!priorityQueue.isEmpty() ) {
           final Person person = priorityQueue.remove();
            if(Library.getAvailableBooks().containsKey(book.getBookTitle())){ // check if the book is in the library arn return the number)
                Integer copiesAvailable = Library.getAvailableBooks().get(book.getBookTitle());
                if(copiesAvailable != 0){
                    Set<String> borrowedBooks = new HashSet<>();
                        borrowedBooks.add(book.getBookTitle());//books demanded exceeds number available, borrow only one
                    person.getBooksBorrowed().add(book.getBookTitle());
                        person.setBooksBorrowed(borrowedBooks);
                        Library.getAvailableBooks().put(book.getBookTitle(),copiesAvailable-1);
                        return  "1 copy of the book "+book.getBookTitle()+" is borrowed to "+person.getFirstName();
                } else throw new LibraryException("No copy of the book "+book.getBookTitle()+" in the library");
            } else return
                    "Sorry "+person.getFirstName()+ " the book, "+book.getBookTitle()+ " is not in our Library yet";
        } else return "please register with the Library first!!!";

    }

    @Override
    public String lendBookToUserByFifo( Book book) throws LibraryException {
        if(!personQueue.isEmpty() ) {
            final Person person = personQueue.remove();
            if(Library.getAvailableBooks().containsKey(book.getBookTitle())){
                Integer copiesAvailable = Library.getAvailableBooks().get(book.getBookTitle());
                if(copiesAvailable != 0){
                    Set<String> borrowedBooks = new HashSet<>();
                    borrowedBooks.add(book.getBookTitle());//books demanded exceeds number available, borrow only one
                    person.setBooksBorrowed(borrowedBooks);
                    Library.getAvailableBooks().put(book.getBookTitle(),copiesAvailable-1);
                    return  "1 copy of the book "+book.getBookTitle()+" is borrowed to "+person.getFirstName();
                } else throw new LibraryException("No copy of the book "+book.getBookTitle()+" in the library");
            } else return
                    "Sorry "+person.getFirstName()+ " the book, "+book.getBookTitle()+ " is not in our Library yet";
        } else return "please register with the Library first!!!";

    }

    @Override
    public String collectBookFromUser(Person person, String bookTitle) {
        Set<String> borrowedBooks = person.getBooksBorrowed();
        if(borrowedBooks.contains(bookTitle)){
            Library.getAvailableBooks().put(bookTitle,1);
            borrowedBooks.remove(bookTitle);
            return "The book "+bookTitle+ " has been returned to the library by "+person.getFirstName();
        }else
            return "This book has not been borrowed by "+person.getFirstName();
    }

}
