import Enums.Position;
import Exceptions.LibraryException;
import Model.Book;
import Model.Person;
import ServiceImplementation.Librarian;
import ServiceImplementation.User;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class App {

    public static void main(String[] args) {
//        IMPLEMENTATION 1: Create Users to Make use of the Library

        User seniorStudent1 = new User("Chidi",Position.SENIOR_STUDENT);
        User juniorStudent1 = new User("Emeka", Position.JUNIOR_STUDENT);
        User teacher = new User("Sir Mark",Position.TEACHER);
        Librarian librarian = new Librarian("Thomas",Position.LIBRARIAN);
        User juniorStudent2 = new User("Christian", Position.JUNIOR_STUDENT);

        Book book1 = new Book("Biolgy","Emeka",4);
        Book book2 = new Book("Maths","Stroud",3);
        Book book3 = new Book("Chemistry","Ababio",2);
        Book book4 = new Book("Physics","Nelkon and Parker",3);

//        Populate the School Library with books to be borrowed
        System.out.println(librarian.addBookToLibrary(book1));
        System.out.println(librarian.addBookToLibrary(book2));
        System.out.println(librarian.addBookToLibrary(book3));
        System.out.println(librarian.addBookToLibrary(book4)+"\n");

//        System.out.println(seniorStudent1.requestForBook(book1));


        PriorityQueue<Person> priorityQueue = new PriorityQueue();
        priorityQueue.add(seniorStudent1);
        priorityQueue.add(juniorStudent1);
        priorityQueue.add(teacher);
        priorityQueue.add(juniorStudent2);

        Iterator<Person> iterator = priorityQueue.iterator();
        while(iterator.hasNext()){
//            System.out.println(priorityQueue.poll());
          try{
                      System.out.println(librarian.lendBookToUser(priorityQueue.poll(), book1,0));
          } catch (LibraryException e){
                System.err.println("Book not available");
            }
        }

//        Queue<Person> personQueue = new LinkedList<>();
//
//        personQueue.add(seniorStudent1);
//        personQueue.add(juniorStudent1);
//        personQueue.add(teacher);
//        personQueue.add(juniorStudent2);
//
//
//        Iterator<Person> iterator2 = personQueue.iterator();
//        while(iterator2.hasNext()){
////            System.out.println(priorityQueue.poll());
//
//            try {
//                System.out.println(librarian.lendBookToUser(personQueue.poll(), book1,1));
//
//            } catch (LibraryException e){
//                System.err.println("Book not available");
//            }
//        }




       // Register the Users to access the Library
//      librarian.registerUser(seniorStudent1);
//       librarian.registerUser(juniorStudent1);
//       librarian.registerUser(teacher);
//        librarian.registerUser(juniorStudent2);


//      Normal Implementation of First Come First Serve
//        System.out.println(librarian.lendBookToUser(seniorStudent1,book1,1));
//        System.out.println(librarian.lendBookToUser(juniorStudent1,book1,1));
//        System.out.println(librarian.lendBookToUser(teacher,book1,1));
//        System.out.println(librarian.lendBookToUser(juniorStudent1,book1,1));


//        librarian.lendBookToUserByPriority();
//        librarian.lendBookToUserByPriority();
//        librarian.lendBookToUserByPriority();
//        librarian.lendBookToUserByPriority();






//        IMPLEMENTATION 2
    }
}
