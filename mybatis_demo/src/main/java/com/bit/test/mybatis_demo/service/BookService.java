package com.bit.test.mybatis_demo.service;

import com.bit.test.mybatis_demo.controller.BookController;
import com.bit.test.mybatis_demo.mappers.BookMapper;
import com.bit.test.mybatis_demo.model.Book;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName BookService.java
 * @Description TODO
 * @createTime 2019年11月27日 17:26:00
 */
@Service
public class BookService {
    @Autowired(required = false)
    private BookMapper bookMapper;

    Logger logger = LoggerFactory.getLogger(BookService.class);

    @Transactional(rollbackFor = Exception.class)
    public Book createBook() {
        Book book = new Book();
        book.setName("最终幻想1");
        book.setAuthor("way1");
        bookMapper.save(book);

        try {
            BookService service = (BookService) AopContext.currentProxy();
            service.updateBook(book);
            //this.updateBook(book);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return book;
    }

    @Transactional
    public void updateBook(Book book) {
        book.setCreateTime("2019-11-27 17:00");
        bookMapper.update(book);
        int i = 1 / 0;
    }
}