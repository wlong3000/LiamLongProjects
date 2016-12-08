/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var url = window.location.pathname;
var urlSplit = url.split("displayPost");
var id = urlSplit[1];

$(document).ready(function () {
    loadPost();
});

function loadPost() {
   
    

    $.ajax({
        url: 'post/' + id
    }).success(function (data, status) {
        fillPostInfo(data, status);
        fillTags(data, status);
        fillComments(data, status);
    });
}

function fillPostInfo(post, status) {
    document.getElementById("postTitle").innerHTML = post.title;
    document.getElementById("postAuthor").innerHTML = "by " + post.author;
    document.getElementById("postInfo").innerHTML = '<span class="glyphicon glyphicon-user"></span><a href="#"> ' + post.author + ' </a>&nbsp;'
            + '<span class="glyphicon glyphicon-time"></span> Posted on ' + post.month + " " + post.day + ", " + post.year + '&nbsp;'
            + '<span class="glyphicon glyphicon-duplicate"></span><a href="#"> ' + post.category + ' </a>&nbsp;'
            + '<span class="glyphicon glyphicon-comment"></span><a href="#"> ' + post.commentList.length + ' Comments </a>&nbsp;';
    document.getElementById("postBody").innerHTML = post.body;
    document.getElementById("postId").value = id;
}

function fillTags(post, status) {
    var tagTable = $('#postTags');

    for (var i = 0; i < post.tagList.length; i++) {
        tagTable.append($('<a href="#">#' + post.tagList[i] + ' </a></'));
    }
}


function fillComments(post, status) {
    var commentTable = $('#commentTable');
    for (var i = 0; i < post.commentList.length; i++) {
        var comment = post.commentList[i];
        commentTable.append($('<div class="media">'
                + '<a class="pull-left" href="#"><img class="media-object" src="http://placehold.it/64x64" alt=""></a>'
                + '<div class="media-body">'
                + '<h4 class="media-heading">' + comment.name
                + '<small> ' + comment.date + ' </small><a href="deleteComment/' + comment.commentId + '"> Delete  </a>'
                + '</h4>' + comment.text + '</div>'
                ));
    }
}

