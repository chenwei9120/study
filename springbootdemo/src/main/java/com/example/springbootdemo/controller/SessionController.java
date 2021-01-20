package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName SessionController
 * @Description TODO
 * @createTime 2021-01-19 16:26:00
 */
@RestController
@RequestMapping("/session")
public class SessionController {

    @PostMapping("/write")
    public void write(@RequestParam String word, HttpServletRequest request) {
        request.getSession().setAttribute("word", word);
    }

    @GetMapping("/read")
    public String read(HttpServletRequest request) {
        return String.valueOf(request.getSession().getAttribute("word"));
    }
}
