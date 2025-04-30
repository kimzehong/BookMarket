package kr.ac.kopo.kjh.bookmarket.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Data
//@Setter
//@Getter
//@NoArgsConstructor
public class Book {
    private String bookID;  //도서 ID
    private String name;    //도서 제목
    private BigDecimal unitPrice;   //가격
    private String author;  //저자
    private String publisher;   //출판사
    private String description; //설명
    private String category;    //분류
    private long unitInStock;   //재고수
    private String releaseDate; //출판일(월/년)
    private String condition;   //신규,중고,전자책
}