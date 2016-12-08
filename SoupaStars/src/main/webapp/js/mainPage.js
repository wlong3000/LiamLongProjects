/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    loadPosts();
    loadTabs();
    $('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var postId = element.data('post-id');
    var modal = $(this);

    // get our object via AJAX
    $.ajax({
        type: 'GET',
        url: 'post/' + postId
    }).success(function (sampleEditPost) {
        modal.find('#edit-post-id').val(sampleEditPost.postId);
        modal.find('#edit-title').val(sampleEditPost.title);
       
        modal.find('#edit-body').val(sampleEditPost.body);
        modal.find('#edit-category').val(sampleEditPost.category);
        var tagString = "";
        for (var i = 0; i < sampleEditPost.tagList.length; i++){
            tagString += "#" + sampleEditPost.tagList[i] + " ";
        }
        modal.find('#edit-taglist').val(tagString);
        
        // needed to have posts show previous text when using tinyMCE
      tinyMCE.activeEditor.setContent($('#edit-body').val());
      
    });
   
});

$('#edit-button').click(function (event) {
    event.preventDefault();
    var tagList = [];
    tagList.push($('#edit-taglist').val());
    
    // update our post via AJAX
    $.ajax({
        type: 'PUT',
        url: 'post/' + $('#edit-post-id').val(),
        data: JSON.stringify({
            postId: $('#edit-post-id').val(),
            title: $('#edit-title').val(),
            body: tinyMCE.activeEditor.getContent(),
            category: $('#edit-category').val(),
            tagList: tagList
     

        }),
        
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
        
    }).success(function () {
           
            

        // used to reload the page after updating
        location.reload();
    });
   
});



});
// add the onclick handling for our add button
$('#add-button').click(function (event) {
    event.preventDefault();
    // need to submit this via AJAX
    $.ajax({
        type: 'POST',
        url: 'post',
        // make the JSON contact
        data: JSON.stringify({
            title: $('#add-title').val(),
            author: $('#add-author').val(),
            body: $('#add-body').val(),
            category: $('#add-category').val(),
            taglist: $('#add-taglist').val()

        }),
        contentType: 'application/json; charset=utf-8',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        dataType: 'json'
    }).success(function () {
        // removing data, status for a question on if we need them
        // realistically, if you are getting an object back from an endpoint
        // and you need to work with the data coming back, 
        // then you want to include the parameters in the anonymous function's signature
        // clear the form and reload the summary table
        $('#add-title').val('');
        $('#add-author').val('');
        $('#add-body').val('');
        $('#add-category').val('');
        $('#add-taglist').val('');
    


        // reload the summary table
        $('#validationErrors').empty();
        loadPosts();
    }).error(function (data, status) {
        $('#validationErrors').empty();
        $.each(data.responseJSON.fieldErrors, function (index, validationError) {
            var errorDiv = $('#validationErrors');
            errorDiv.append(validationError.message).append($('<br>'));
        });
    });
});




function loadPosts() {
    //Get our JSON objects from the controller
    $.ajax({
        url: 'post',
        contentType: 'application/json',
        dataType: 'json'
    }).success(function (data, status) {
        fillPostTable(data, status);
        fillAuthorTable(data, status);
        fillCategoryTable(data, status);
        fillTagTable(data, status);
    });
}

function fillPostTable(postList, status) {
    clearPostTable();
    var postTable = $('#postRows');
    var sortedPosts = postList.sort(function (a, b) {
        return b.postId - a.postId;
    });
    $.each(sortedPosts, function (arrayPosition, post) {
        var shortText = post.body.substring(0,480);
        if(shortText.length===480){
            shortText+="...";
        }
        postTable.append($('<tr>')
                
                        .append($('<h2>' + post.title + '</h2>\n\
        <p><span class="glyphicon glyphicon-user"></span><a href="#"> ' + post.author + '</a>&nbsp;\n\
        <span class="glyphicon glyphicon-time"></span> Posted on ' + post.month + ' ' + post.day + ', ' + post.year + '&nbsp;\n\
        <span class="glyphicon glyphicon-duplicate"></span><a href="#"> ' + post.category + ' </a>&nbsp;\n\
        <span class="glyphicon glyphicon-comment"></span><span> ' + post.commentList.length + " Comments</span>"
                                + '<p>' + shortText + '</p>'
                                )));
              


        var tags = "";
        for (var i = 0; i < post.tagList.length; i++) {
            tags = tags + "#" + post.tagList[i] + " ";

        }

        postTable.append($('<p>' + tags + '</p><a class="btn btn-primary" href="displayPost' + post.postId + '">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>'));
                   postTable.append($('<span>&nbsp</span>')
                    //   .append($('<span>&nbsp</span>')
               
                  .append($('<a>')
                                .attr({
                                    'class': 'btn btn-primary',
                                    'data-post-id': post.postId,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .text('Edit')))
               .append($('<span>&nbsp</span>')
                        .append($('<a>')
                                .attr({
                                    'class': 'btn btn-primary',
                                    'onClick': 'deletePost(' + post.postId + ')'
                                })
                                .text('Delete')));
     //   postTable.append($('<span>&nbsp</span><a class="btn btn-primary" href="editBlogPostForm' + post.postId + '">Edit <span class="glyphicon glyphicon"></span></a>'));
      //  postTable.append($('<span>&nbsp</span><a class="btn btn-primary" href="deleteBlogPost' + post.postId + '">Delete <span class="glyphicon glyphicon"></span></a>'));

    });
    
}
function fillAuthorTable(postList, status) {
    var authorTable = $('#authorRows');
    authorTable.empty();
    var authorList = [];
    var authorString = "";
    $.each(postList, function (arrayPosition, post) {
        authorString += post.author;
    });
    $.each(postList, function (arrayPosition, post) {
        if (!contains(authorList, post.author)) {
            authorTable.append($('<tr><td><a href="search?searchTerm=' + post.author + '">' + post.author +
                    ' (' + countInstances(authorString, post.author) + ')</a></td></tr>'));
            authorList.push(post.author);
        }
    }
    );
}
function contains(a, obj) {
    for (var i = 0; i < a.length; i++) {
        if (a[i] === obj) {
            return true;
        }
    }
    return false;
}

function countInstances(string, word) {
    var substrings = string.split(word);
    return substrings.length - 1;
}

function fillCategoryTable(postList, status) {
    var categoryTable = $('#categoryRows');
    categoryTable.empty();
    var categoryList = [];
    var categoryString = "";
    $.each(postList, function (arrayPosition, post) {

        categoryString += post.category;

    });
    $.each(postList, function (arrayPosition, post) {
        if (!contains(categoryList, post.category)) {
            categoryTable.append($('<tr><td><a href="search?searchTerm=' + post.category + '">' + post.category + ' ('
                    + countInstances(categoryString, post.category) + ')</a></td></tr>'));
            categoryList.push(post.category);
        }
    });
}

function fillTagTable(postList, status) {
    var tagTable = $('#tagRows');
    tagTable.empty();
    var tagList = [];
    $.each(postList, function (arrayPosition, post) {
        for (var i = 0; i < post.tagList.length; i++) {
            if (!contains(tagList, post.tagList[i]) && tagList.length <= 20) {
                tagTable.append($('<a href="search?searchTerm=' + post.tagList[i] + '">#' + post.tagList[i] + ' </a></'));
                tagList.push(post.tagList[i]);
            }
        }
    });
}



function clearPostTable() {
    $('#postRows').empty();
}

function deletePost(id) {
    var answer = confirm('Do you really want to delete this Post?');

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: '/SoupaStars/deleteBlogPost' + id
        }).success(function () {
            // reload summary
            loadPosts();
        });
    }
}  



$(function () {

    $("#searchTerm").autocomplete({
        source: function (request, response) {
            $.ajax({
                url: "SearchController/search/" + $("#searchTerm").val(),
                type: "POST",
                dataType: "json",
                success: function (data) {
                    if (typeof Array.prototype.forEach !== 'function') {
                        Array.prototype.forEach = function (callback) {
                            for (var i = 0; i < this.length; i++) {
                                callback.apply(this, [this[i], i, this]);

                            }
                        };

                    }

                    var values = data;
                    var newArray = new Array(values.length);
                    var i = 0;
                    values.forEach(function (entry) {
                        var newObject = {
                            label: entry.title
                        };
                        var newObject = {
                            label: entry.author
                        };
                        newArray[i] = newObject;
                        i++
                    });
                    response(newArray);
                }
            });
        },
        minLength: 1
    });

});

$("#searchTerm").on('submit', function (name, url){
    if (!url) {
      url = window.location.href;
    }
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
    
    });



