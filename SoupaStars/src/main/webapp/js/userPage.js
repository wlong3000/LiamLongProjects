/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    loadStaticPageList();
    $('#editModal').on('show.bs.modal', function (event) {
        var element = $(event.relatedTarget);
        var pageId = element.data('post-id');
        var modal = $(this);

        // get our object via AJAX
        $.ajax({
            type: 'GET',
            url: 'staticPage/' + pageId
        }).success(function (sampleEditPage) {
            modal.find('#edit-page-id').val(sampleEditPage.pageId);
            modal.find('#edit-title').val(sampleEditPage.title);
            modal.find('#edit-body').val(sampleEditPage.body);
            modal.find('#edit-expirationDate').val(sampleEditPage.expirationDate);

            // needed to have posts show previous text when using tinyMCE
            tinyMCE.activeEditor.setContent($('#edit-body').val());
        });

    });

    $('#edit-button').click(function (event) {
        event.preventDefault();
        // update our post via AJAX
        $.ajax({
            type: 'PUT',
            url: 'editStaticPage/' + $('#edit-page-id').val(),
            data: JSON.stringify({
                pageId: $('#edit-page-id').val(),
                title: $('#edit-title').val(),
                body: tinyMCE.activeEditor.getContent(),
                expirationDate: $('#edit-expirationDate').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            location.reload();
        });
    });

});


function loadStaticPageList() {
    $.ajax({
        url: 'staticPages',
        contentType: 'appliction/json',
        dataType: 'json'
    }).success(function (data, status) {
        fillStaticPageTable(data, status);
    });
}

function fillStaticPageTable(pageList, status) {
    var pageTable = $('#static-page-table');
    pageTable.empty();
    $.ajax({
        type: 'GET',
        url: 'currentUser'
    }).success(function (author, status) {
        document.getElementById("username").innerHTML = author + "'s User Page";
        $.each(pageList, function (arrayPosition, page) {
            if (author === page.author) {
                pageTable.append($('<tr><td><h4><a href="displayStaticPage' + page.pageId +
                        '">' + page.title + '</a></h4></td>'
                        + '<td>' + page.expirationDate + '</td>'



                        //   + '<td><a class="btn btn-primary" href="#" >Edit Page</a></td>'
                        //    + '<td><a class="btn btn-primary "href="deleteStaticPage' + page.pageId +'">Delete Page</a></td>'
                        + '</tr>'));
                pageTable.append($('<span>&nbsp</span>')
                        //   .append($('<span>&nbsp</span>')

                        .append($('<a>')
                                .attr({
                                    'class': 'btn btn-primary',
                                    'data-post-id': page.pageId,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .text('Edit')))
                        .append($('<span>&nbsp</span>')
                                .append($('<a>')
                                        .attr({
                                            'class': 'btn btn-danger',
                                            'onClick': 'deleteStaticPage(' + page.pageId + ')'
                                        })
                                        .text('Delete')));
            }
        });
    });
}

function deleteStaticPage(id) {
    var answer = confirm('Do you really want to delete this Static Page?');

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: '/SoupaStars/deleteStaticPage' + id
        }).success(function () {
            // reload summary
            loadStaticPageList();
        });
    }
} 