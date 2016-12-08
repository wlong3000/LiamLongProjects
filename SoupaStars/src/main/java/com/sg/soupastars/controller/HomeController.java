/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.controller;

import com.sg.soupastars.dao.SoupaStarsCommentDBImpl;
import com.sg.soupastars.dao.SoupaStarsCommentDao;
import com.sg.soupastars.model.Post;
import java.io.FileNotFoundException;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.sg.soupastars.dao.SoupaStarsPostDao;
import com.sg.soupastars.dao.SoupaStarsStaticPageDao;
import com.sg.soupastars.dao.SoupaStarsStaticPageDaoDBImpl;
import com.sg.soupastars.model.Comment;
import com.sg.soupastars.model.StaticPage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {

    private SoupaStarsPostDao pdao;

    private SoupaStarsCommentDao cdao;
    private SoupaStarsStaticPageDao spdao;

    @Inject
    public HomeController(SoupaStarsPostDao pdao, SoupaStarsCommentDao cdao, SoupaStarsStaticPageDao spdao) {
        this.pdao = pdao;
        this.cdao = cdao;
        this.spdao = spdao;
    }

    // Main  Page
    @RequestMapping(value = {"/mainPage", "/"}, method = RequestMethod.GET)
    public String displayMainPage() {
        return "mainPage";
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "home";
    }

    // - Retrieve a Post by Id (GET)
//        - /post/{postId}
//        - Response Body: POST in JSON  
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Post getPost(@PathVariable("id") int id) {
        return pdao.getPostById(id);
    }

//- Create a Post (POST)
//       - RequestBody - JSON object of our Post
    // - ResponseBody - JSON object of our Post
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Post createPost(@Valid @RequestBody Post post) {
        pdao.addPost(post);
        return post;
    }

    // Display New Blog Post Form
    @RequestMapping(value = "displayBlogPostForm", method = RequestMethod.GET)
    public String displayNewBlogForm(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);

        return "displayBlogPostForm";
    }

    // Add a new Blog Post
    @RequestMapping(value = "/addNewBlogPost", method = RequestMethod.POST)
    public String addNewPost(HttpServletRequest req, @Valid @ModelAttribute("post") Post post, BindingResult result) throws IOException {

        if (result.hasErrors()) {
            return "displayBlogPostForm";
        }
        if (post.tagList != null) {
            String tagString = post.tagList.get(0);
            post.tagList.clear();
            String[] tagArray = tagString.split("#");
            for (String tag : tagArray) {
                if(!tag.equals("")){
                post.tagList.add(tag);
                }
            }
        }
        pdao.addPost(post);

        return "redirect:mainPage";
    }

    // Delete a  Blog Post
    @RequestMapping(value = "/deleteBlogPost{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletePost(@PathVariable("id") int id) {
        pdao.removePost(id);
        return "redirect:mainPage";
    }

//- Update a Post (PUT)
//        - post/{postId}
//        - RequestBody: JSON object of our Post, with the postId
    @RequestMapping(value = "/post/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable("id") int id, @Valid @RequestBody Post post) {
        post.setPostId(id);
        if (post.tagList != null) {
            String tagString = post.tagList.get(0);
            post.tagList.clear();
            String[] tagArray = tagString.split("#");
            for (String tag : tagArray) {
                if(!tag.equals("")){
                post.tagList.add(tag);
                }
            }
        }
        pdao.updatePost(post);
    }

//- Retrieve ALL Posts (GET)
//        - /post
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> getAllPosts() {
        return pdao.getAllPosts();
    }

    @RequestMapping(value = "/displayPost{id}", method = RequestMethod.GET)
    public String displayPost(Model model) throws FileNotFoundException {
        List<Post> allPost = pdao.getAllPosts();
        model.addAttribute("posts", allPost);
        return "displayPost";
    }

    // Comments 
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Comment getComment(@PathVariable("id") int id) {
        return cdao.getCommentById(id);
    }

//- Create a Comment (POST)
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(HttpServletRequest req, HttpServletResponse response) throws IOException {
        Comment comment = new Comment();
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("hh:mm MMMM dd, yyyy");
        String dateString = dateformat.format(date);

        comment.setName(req.getParameter("username"));
        comment.setEmail(req.getParameter("email"));
        comment.setText(req.getParameter("comment-body"));
        comment.setDate(dateString);
        int postID = Integer.parseInt(req.getParameter("postId"));
        cdao.addComment(comment, postID);
        response.sendRedirect("/SoupaStars/displayPost" + postID);
    }

//- Delete a Comment (DELETE)
    @RequestMapping(value = "/deleteComment/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
        int postId = cdao.removeComment(id);
        response.sendRedirect("/SoupaStars/displayPost" + postId);
    }

//- Update a Comment (PUT)
    @RequestMapping(value = "/editComment/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable("id") int id, @Valid @RequestBody Comment comment) {
        comment.setCommentId(id);
        cdao.updateComment(comment);
    }

//- Retrieve ALL Comments (GET)
    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> getAllComments() {
        return cdao.getAllComments();
    }

    // I am unsure about this. The RequestMapping cannot be /displayPost since it
    // would be ambigious. However we do not have a displayComment page.
    @RequestMapping(value = "/displayComment", method = RequestMethod.GET)
    public String displayComment(Model model) throws FileNotFoundException {
        List<Comment> allComment = cdao.getAllComments();
        model.addAttribute("comment", allComment);

        // return the logical view
        return "displayComment";
    }

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String displayUserPage() {
        return "userPage";
    }

    @RequestMapping(value = "/displayStaticPageForm", method = RequestMethod.GET)
    public String showStaticPageForm(Model model) {
        StaticPage page = new StaticPage();
        model.addAttribute("page",page);
        return "displayStaticPageForm";
    }

    // Add a new Static Page
    @RequestMapping(value = "/addNewStaticPage", method = RequestMethod.POST)
    public String addNewPage(HttpServletRequest req)  {

        StaticPage page = new StaticPage();  
        page.setTitle(req.getParameter("title"));
        page.setBody(req.getParameter("body"));
        String expirationString = req.getParameter("expirationDate");
        
        String[] expirationArray = expirationString.split("/");

        try {
            int month = Integer.parseInt(expirationArray[0]);
            int day = Integer.parseInt(expirationArray[1]);
            int year = Integer.parseInt(expirationArray[2]);
            if (month < 1 || month > 12
                    || day < 1 || day > 31
                    || year < 1900 || year > 2100) {
                expirationString = "N/A";
            }
        } catch (NumberFormatException nfe) {
            expirationString = "N/A";
        }
       
      
       page.setExpirationDate(expirationString);
        spdao.create(page);

        return "userPage";
    }

    @RequestMapping(value = "/deleteStaticPage{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteStaticPage(@PathVariable("id") int id) {
        StaticPage page = spdao.selectPageById(id);
        spdao.delete(page);
        return "redirect:userPage";
    }

    @RequestMapping(value = "/editStaticPage/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStaticPage(@PathVariable("id") int id, @Valid @RequestBody StaticPage page) {
        page.setPageId(id);
        spdao.update(page);
    }
     
    
    @RequestMapping(value = "/displayStaticPage{id}", method = RequestMethod.GET)
    public String displayStaticPage(Model model) throws FileNotFoundException {
        List<Post> allPost = pdao.getAllPosts();
        model.addAttribute("posts", allPost);
        return "displayStaticPage";
    }

    @RequestMapping(value = "/staticPage/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StaticPage getStaticPage(@PathVariable("id") int id) {
        return spdao.selectPageById(id);
    }

    @RequestMapping(value = "/staticPages", method = RequestMethod.GET)
    @ResponseBody
    public List<StaticPage> getAllStaticPages() {
        return spdao.getAllStaticPages();
    }

    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearchPage(HttpServletRequest req, Model model){
        String newTerm = req.getQueryString();
        String newerTerm = newTerm.replaceAll("[+%,0123456789&]", " ");
       String newestTerm = newerTerm.replace("searchTerm=", "");
       String searchTerm = newestTerm.replaceAll("\\s+", " ");
        List resultList = pdao.searchPosts(searchTerm);
        model.addAttribute("searchList", resultList);
        return "search";
    }
    
//    @RequestMapping(value = "/searchPost", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Post> displaySearchPost (List searchList){
//    
//    return searchList;   
//    }
    
    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    @ResponseBody
    public String getCurrentUser(){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String user = authentication.getName();
        return user;
    }

}
