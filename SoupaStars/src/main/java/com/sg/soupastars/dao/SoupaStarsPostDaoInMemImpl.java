/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.dao;

import com.sg.soupastars.model.Post;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class SoupaStarsPostDaoInMemImpl implements SoupaStarsPostDao {
    private Map<Integer, Post> postMap = new HashMap<>();
    private static int postIdCounter = 0;

    @Override
    public Post addPost(Post post) {
        // We need to keep track of the ID manually right now
        // In our DB implementation, the database will assign the ID
        post.setPostId(postIdCounter);
        // Once we assign the ID, we need to increment the counter for the next dvd
        postIdCounter++;
        // add our dvd to the map
        postMap.put(post.getPostId(), post);
        // We need to return the dvd per the interface
        return post;
    }

    @Override
    public Post getPostById(int postId) {
        return postMap.get(postId);
    }

    @Override
    public List<Post> getAllPostsByTitle(String searchByName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> allPost = new ArrayList<>(postMap.values());
        return allPost;
    }

    @Override
    public void updatePost(Post post) {
        postMap.put(post.getPostId(), post);
    }

    @Override
    public void removePost(int postId) {
        postMap.remove(postId);
    }

//    @Override
//    public List<Post> searchDVD(Map<SearchTerm, String> criteria) {
//        // Get all the things we're searching for into individual variables
//        String titleCriteria = criteria.get(SearchTerm.TITLE);
//        String releaseDateCriteria = criteria.get(SearchTerm.RELEASE_DATE);
//        String mpaaRatingCriteria = criteria.get(SearchTerm.MPAA_RATING);
//        String directorsNameCriteria = criteria.get(SearchTerm.DIRECTORS_NAME);
//        String studioCriteria = criteria.get(SearchTerm.STUDIO);
//        String userRatingCriteria = criteria.get(SearchTerm.USER_RATING);
//
//        // Declare predicate conditions - to be used by our filters
//        Predicate<DVD> titleMatches;
//        Predicate<DVD> releaseDateMatches;
//        Predicate<DVD> mpaaRatingMatches;
//        Predicate<DVD> directorsNameMatches;
//        Predicate<DVD> studioMatches;
//        Predicate<DVD> userRatingMatches;
//
//        // Default Predicate
//        Predicate<DVD> truePredicate = (c) -> {
//            return true;
//        };
//
//        titleMatches = (titleCriteria == null || titleCriteria.isEmpty()) 
//                ? truePredicate
//                : (c) -> c.getTitle().toLowerCase().startsWith(titleCriteria.toLowerCase());
//
//        releaseDateMatches = (releaseDateCriteria == null || releaseDateCriteria.isEmpty())
//                ? truePredicate
//                : (c) -> c.getReleaseDate().toLowerCase().startsWith(releaseDateCriteria.toLowerCase());
//
//        mpaaRatingMatches = (mpaaRatingCriteria == null || mpaaRatingCriteria.isEmpty())
//                ? truePredicate
//                : (c) -> c.getMpaaRating().toLowerCase().startsWith(mpaaRatingCriteria.toLowerCase());
//
//        directorsNameMatches = (directorsNameCriteria == null || directorsNameCriteria.isEmpty())
//                ? truePredicate
//                : (c) -> c.getDirectorsName().toLowerCase().startsWith(directorsNameCriteria.toLowerCase());
//
//        studioMatches = (studioCriteria == null || studioCriteria.isEmpty())
//                ? truePredicate
//                : (c) -> c.getStudio().toLowerCase().startsWith(studioCriteria.toLowerCase());
//
//        userRatingMatches = (userRatingCriteria == null || userRatingCriteria.isEmpty())
//                ? truePredicate
//                : (c) -> c.getUserRating().toLowerCase().startsWith(userRatingCriteria.toLowerCase());
//
//        // Return the list of contacts that match the given criteria 
//        // We will filters and join them with AND
//        return postMap.values().stream()
//                .filter(titleMatches
//                        .and(releaseDateMatches)
//                        .and(mpaaRatingMatches)
//                        .and(directorsNameMatches)
//                        .and(studioMatches)
//                        .and(userRatingMatches))
//                .collect(Collectors.toList());
//
//    }

    @Override
    public List<Post> read(Integer postId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Post> searchPosts(String searchTerm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}