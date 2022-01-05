import Enums.Position;
import Exceptions.LibraryException;
import Model.Book;
import Model.Library;
import Model.Person;
import ServiceImplementation.Librarian;
import ServiceImplementation.User;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
//        IMPLEMENTATION 1: Create Users to Make use of the Library
        Librarian librarian = new Librarian("Thomas",Position.LIBRARIAN);
        List<User> userList = List.of(
                new User("Chidi", Position.SENIOR_STUDENT),
                new User("Emeka", Position.JUNIOR_STUDENT),
                new User("Sir Mark",Position.TEACHER),
                new User("Christian", Position.JUNIOR_STUDENT),
                new User("Ebuka",Position.SENIOR_STUDENT),
                new User("Sir Josh",Position.TEACHER)
        );

//          Create Books
        Book book1 = new Book("Biolgy","Emeka",5);
        Book book2 = new Book("Maths","Stroud",6);
//        Book book3 = new Book("Chemistry","Ababio",2);
//        Book book4 = new Book("Physics","Nelkon and Parker",3);

//        Populate the School Library with books to be borrowed
        System.out.println(librarian.addBookToLibrary(book1));
        System.out.println(librarian.addBookToLibrary(book2));
//librarian.registerUser2.accept();

        System.out.println("Initial Books: " + Library.getAvailableBooks());


        userList.stream()
                .filter(userList::contains)
                .forEach(librarian::registerUser);
        System.out.println(Librarian.getPriorityQueue().toString());

//        userList.stream().forEach(librarian::registerUser);
//        System.out.println(Librarian.getPriorityQueue().toString());
//        for(int i =0; i< librarian.getCount(); i++){
//            try {
//                System.out.println(librarian.lendBookToUserByPriority(book2));
//            }catch (LibraryException e){System.err.println(e);}
//        }

        System.out.println("\n\n");

        Librarian.getPriorityQueue().stream().forEach(person -> {
            try {
                System.out.println(librarian.lendBookToUserByFifo(book1));
            }catch (LibraryException e){
                System.out.println(e);

            }
        });
        userList.stream().forEach(librarian::registerUser);
        System.out.println(Librarian.getPriorityQueue().toString());

        for(int i =0; i< Librarian.getPriorityQueue().size(); i++){
            try {
                System.out.println(librarian.lendBookToUserByFifo(book2));
            }catch (LibraryException e){
                System.out.println(e);

            }
        }

        System.out.println("\nRemaining Books: " + Library.getAvailableBooks());
        System.out.println(Librarian.getPriorityQueue().toString());

    }
}
