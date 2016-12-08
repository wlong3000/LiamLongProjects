/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.dao;

import com.sg.soupastars.model.Post;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface SoupaStarsPostDao {
    
    public Post addPost(Post post);
     
    public List<Post> read(Integer postId);
    
    public Post getPostById(int PostId);
    
    public List<Post> getAllPostsByTitle(String titleToSearch);
    
    public List<Post> getAllPosts();
    
    public List<Post> searchPosts(String searchTerm);
    
    public void updatePost(Post post);
    
    public void removePost(int postId);

    
    
   
 
    
   

}
