///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sg.soupastars.controller;
//
//import com.sg.soupastars.dao.SoupaStarsStaticPageDao;
//import com.sg.soupastars.model.StaticPage;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//import javax.inject.Inject;
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// *
// * @author apprentice
// */
//@Controller
//@RequestMapping(value = "/staticpage")
//public class StaticPageController {
//    
//    private SoupaStarsStaticPageDao dao;
//    
//    @Inject
//    public StaticPageController(SoupaStarsStaticPageDao dao) {
//        this.dao=dao;
//    }
//    
//   @RequestMapping(value = "", method = RequestMethod.GET)
//    public String home(Map model) {
//
//        List<StaticPage> pages = dao.getAllStaticPages();
//
//        model.put("staticPage", new StaticPage());
//        model.put("staticPageList", pages);
//         return "adminStaticPageHome";
//    };
//
//
//    
//    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
//    public String show(@PathVariable("id") Integer staticPageId, Map Model) {
//
//        StaticPage staticPage = dao.selectPageById(staticPageId);
//
//        Model.put("page", staticPage);
//
//        return "adminShowStaticPage";
//
//    }
//
//    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
//    public String getToUpdate(@PathVariable("id") Integer pageId, Map model) {
//
//        StaticPage page = dao.selectPageById(pageId);
//
//        model.put("page", page);
//
//        return "adminStaticPageUpdate";
//
//    }
//
//    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
//    @ResponseBody
//    public StaticPage editSubmit(@RequestBody StaticPage staticPage) {
//
//        dao.update(staticPage);
//
//        return staticPage;
//
//    }
//
//
//
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    @ResponseBody
//    public StaticPage create(@RequestBody StaticPage staticPage) {
//
//
//        //staticPage.setActive(true);
//
//        StaticPage s = dao.create(staticPage);
//
//        return s;
//
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public StaticPage delete(@PathVariable("id") Integer staticPostId) {
//
//        StaticPage staticPage = dao.selectPageById(staticPostId);
//
//        return staticPage;
//
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public void confirmDelete(@RequestBody StaticPage staticPage) {
//
//        dao.delete(staticPage);
//
//    }
//
//    /////////we need a post to web method for static pages!!!!!!!!!!!//////
//
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public String userGoToStaticPAges(Map model) {
//
//        List<StaticPage> pages = dao.listActivePages();
//
//        model.put("staticPage", new StaticPage());
//        model.put("staticPageList", pages);
//
//        return "userStaticPageHome";
//    }
//    
//    
//}