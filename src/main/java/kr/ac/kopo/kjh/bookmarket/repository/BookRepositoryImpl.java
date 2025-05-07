package kr.ac.kopo.kjh.bookmarket.repository;

import kr.ac.kopo.kjh.bookmarket.domain.Book;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private List<Book> listOfBooks = new ArrayList<Book>();

    public BookRepositoryImpl() {

        Book book1 = new Book();
        book1.setBookID("ISBN0001");
        book1.setName("스프링부트완전정복");
        book1.setUnitPrice(BigDecimal.valueOf(35000));
        book1.setAuthor("송미영");
        book1.setDescription("스프링 부트는 스프링을 기반으로 쉽고 빠르게 웹 애플리케이션을 개발할 수 있는 도구입니다."+
                " 이 책에서는 스프링 부트의 기본 개념을 쉽게 이해하고 다양한 실습 예제로 빠르게 익힐 수 있습니다."+
                " 그리고 단계별 실습을 따라 하다 보면 도서 쇼핑몰 구축 프로젝트를 완성할 수 있습니다."+
                " 개념-실습-프로젝트의 3단계 학습으로 스프링 부트를 제대로 익힌다면 개발 시간을 단축하고 생산성을 높일 수 있는 개발자로 성장할 수 있습니다.");
        book1.setPublisher("길벗캠퍼스");
        book1.setCategory("IT교재");
        book1.setUnitInStock(1000);
        book1.setReleaseDate("2024/12/31");
        book1.setCondition("신규도서");
        book1.setFileName("isbn0001.jpg");

        Book book2 = new Book();
        book2.setBookID("ISBN0002");
        book2.setName("자바스크립트입문");
        book2.setUnitPrice(BigDecimal.valueOf(29000));
        book2.setAuthor("조현영");
        book2.setDescription("이 책은 순서도를 이용해 프로그래밍 사고력을 기르는 방법을 알려줍니다."+
                " 프로그램 만들기는 순서도를 그리는 능력을 키우는 데서 시작합니다."+
                " 순서도를 그릴 수 있다면 순서도를 코드로 옮기는 것은 금방입니다."+
                " 자바스크립트의 기초부터 심화까지 핵심 문법을 학습한 후 12가지 프로그램을 만들며 학습한 내용을 확인할 수 있습니다."+
                " 문법 학습과 실습이 적절히 섞여 있어 프로그램을 만드는 방법을 재미있게 익힐 수 있고, 이 과정에서 프로그램의 작동 원리를 자연스럽게 이해할 수 있습니다.");
        book2.setPublisher("길벗");
        book2.setCategory("IT교재");
        book2.setUnitInStock(1000);
        book2.setReleaseDate("2024/02/20");
        book2.setCondition("신규도서");
        book2.setFileName("isbn0002.jpg");

        Book book3 = new Book();
        book3.setBookID("ISBN0003");
        book3.setName("파이썬의정석");
        book3.setUnitPrice(BigDecimal.valueOf(29800));
        book3.setAuthor("조용주,임좌상");
        book3.setDescription("4차 산업혁명의 핵심인 머신러닝, 사물 인터넷(IoT), 데이터 분석 등 다양한 분야에 활용되는\n" +
                "직관적이고 간결한 문법의 파이썬 프로그래밍 언어를 최신 트렌드에 맞게 예제 중심으로 학습\n" +
                "할 수 있습니다.\n" +
                "무엇보다 프로그래밍을 처음 접하는 학생과 파이썬 초보자를 위한 파이썬 입문용 교육교재이\n" +
                "기 때문에 프로그래밍 언어 가운데 가장 쉽고 강력한 파이썬의 기초 내용부터 변수, 반복문,\n" +
                "자료구조, 객체 지향 프로그램의 탄탄한 활용까지 장별로 강화된 연습문제와 실무 프로젝트\n" +
                "등 규모 있는 프로그램으로 실력을 향상시킬 수 있습니다.\n" +
                "이 책의 장점, 3가지 요약\n" +
                "코딩의 개념을 깨우치고 데이터 분석 및 웹 개발의 시작을 위한\n" +
                "파이썬 프로그래밍의 완벽 가이드");
        book3.setPublisher("길벗");
        book3.setCategory("IT교재");
        book3.setUnitInStock(1000);
        book3.setReleaseDate("2023/01/10");
        book3.setCondition("신규도서");
        book3.setFileName("isbn0003.jpg");

        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
    }

    @Override
    public List<Book> getAllBookList() {
        return listOfBooks;
    }

    @Override
    public Book getBookById(String bookId) {
        Book bookInfo = null;
        for (Book book : listOfBooks) {
            if (book != null && book.getBookID() != null && book.getBookID().equals(bookId)){
                bookInfo = book;
                break;
            }

        }

        if(bookInfo==null){
            throw new IllegalArgumentException("도서번호가 " + bookId +"인 해당 도서를 찾을 수 없습니다.");
        }
        return bookInfo;
    }

    @Override
    public List<Book> getBookListByCategory(String category) {
        List<Book> booksByCategory = new ArrayList<>();
        for (Book book : listOfBooks) {
            if (book.getCategory() != null && book.getCategory().equals(category)){
                booksByCategory.add(book);
            }
        }
        return booksByCategory;
    }

    @Override
    public Set<Book> getBookSetByFilter(Map<String, List<String>> filter) {
        Set<Book> booksByPublisher = new HashSet<Book>();
        Set<Book> booksByCategory = new HashSet<Book>();
        Set<String> booksByFilter = filter.keySet();

        if(booksByFilter.contains("publisher")){
            for (int i=0; i< filter.get("publisher").size(); i++){
                String publisherName = filter.get("publisher").get(i);
                for (Book book : listOfBooks) {
                    if(publisherName.equals(book.getPublisher())){
                        booksByPublisher.add(book);
                    }

                }
            }
        }

        if(booksByFilter.contains("category")){
            for (int i=0; i< filter.get("category").size(); i++){
                String categoryName = filter.get("category").get(i);
                List<Book> list = getBookListByCategory(categoryName);
                booksByCategory.addAll(list);
            }
        }


//        저장된 요소 중에서 2 Set을 비교하여 같은 것만 남기고 나머지는 제거하는 역할(교집합을 구한다.)
        booksByCategory.retainAll(booksByPublisher);

        return booksByCategory;
    }

    @Override
    public void setNewBook(Book book) {

    }
}