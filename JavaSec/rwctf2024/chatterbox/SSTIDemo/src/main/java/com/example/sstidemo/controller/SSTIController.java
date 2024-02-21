package com.example.sstidemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by RacerZ
 * @date 2024/2/18.
 */

@Controller
public class SSTIController {
    @RequestMapping({"/"})
    public String index(HttpSession session, Model model) {
        List<Map<String, Object>> messages = new ArrayList<>();
        HashMap<String, Object> entry = new HashMap<>();
        entry.put("content", "racerz");
        entry.put("created_at", "2024-2-18");
        messages.add(entry);
        model.addAttribute("messages", messages);
        return "index";
    }

    // vuln
    @GetMapping("/path")
    public String path(HttpServletRequest request, HttpServletResponse response, Model model) {
        String lang = request.getParameter("lang");
        return "user/" + lang + "/welcome"; // lang is tainted
    }

    @GetMapping("/doc/{document}")
    public void getDocument(@PathVariable String document) {
        System.out.println("Retrieving " + document);
    }
}
