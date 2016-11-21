/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Document ready function
$(document).ready(function () {
    loadDVDs();
});
//on click for the add button
$('#add-button').click(function (event) {
    //prevent form submission
    event.preventDefault();
    $.ajax({
        type: 'POST',
        url: 'dvd',
        //build JSON object from data in the form
        data: JSON.stringify({
            title: $('#add-title').val(),
            releaseYear: $('#add-year').val(),
            rating: $('#add-rating').val(),
            director: $('#add-director').val(),
            studio: $('#add-studio').val(),
            note: $('#add-note').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
        //if the call succeeds, clear the form and reload the summary table
        $('#add-title').val('');
        $('#add-year').val('');
        $('#add-rating').val('');
        $('#add-director').val('');
        $('#add-studio').val('');
        $('#add-note').val('');
        loadDVDs();
    });
});
//on click for the edit button
$('#edit-button').click(function (event) {
    //prevent the button from submitting the whole page
    event.preventDefault();
    //make AJAX call
    $.ajax({
        type: 'PUT',
        url: 'dvd/' + $('#edit-dvd-id').val(),
        data: JSON.stringify({
            serialNumber: $('#edit-dvd-id').val(),
            title: $('#edit-title').val(),
            releaseYear: $('#edit-year').val(),
            rating: $('#edit-rating').val(),
            director: $('#edit-director').val(),
            studio: $('#edit-studio').val(),
            note: $('#edit-note').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function () {
        loadDVDs();
    });
});
//on click for search button
$('#search-button').click(function (event) {
    event.preventDefault();
    $.ajax({
        type: 'POST',
        url: 'search/dvds',
        dataType: 'json',
        data: JSON.stringify({
            title: $('#search-title').val(),
            releaseYear: $('#search-year').val(),
            rating: $('#search-rating').val(),
            director: $('#search-director').val(),
            studio: $('#search-studio').val(),
            note: $('#search-note').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    }).success(function (searchResults, status) {
        $('#search-title').val('');
        $('#search-year').val('');
        $('#search-rating').val('');
        $('#search-studio').val('');
        $('#search-director').val('');
        $('#search-note').val('');
        
        fillDVDTable(searchResults, status);
    });
});
function fillDVDTable(dvdList, status) {
    //clear the previous list
    clearDVDTable();
    //grab the tbody element that will hold the new list of DVDs
    var dvdTable = $('#contentRows');
    $.each(dvdList, function (index, dvd) {
        dvdTable.append($('<tr>')
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-dvd-id': dvd.serialNumber,
                                    'data-toggle': 'modal',
                                    'data-target': '#detailsModal'
                                })
                                .text(dvd.title + ' (' + dvd.releaseYear + ')')
                                )//ends the <a> tag
                        )//ends the <td> tag for the dvd title
                .append($('<td>').text(dvd.rating + ' | ' + dvd.director))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-dvd-id': dvd.serialNumber,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .text('Edit')
                                )
                        )
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteDVD(' + dvd.serialNumber + ')'
                                })
                                .text('Delete')
                                )//ends the <a> tag
                        )//ends the <td> tag for delete
                );//ends the tr for this dvd
    });//ends the each function
}

//Load dvds into the summary table
function loadDVDs() {

    //make ajax call for dvds
    $.ajax({
        url: "dvds"
    }).success(function (data, status) {
        fillDVDTable(data, status);
    });
}

//clear all the rows from the summary table
function clearDVDTable() {
    $('#contentRows').empty();
}
;

//Test Data
var testDVDData = [
    {
        serialNumber: 1,
        title: "Deadpool",
        releaseYear: "2016",
        rating: "R",
        director: "Tim Miller",
        studio: "Marvel Entertainment",
        note: "Not family friendly..."

    }
];
// This code runs in response to the show.bs.modal event - it gets the correct
// contact data and renders it to the dialog
$('#detailsModal').on('show.bs.modal', function (event) {
// Get the element that triggered this event - in our case it is a dvd
// title link in the summary table.  This link has an attribute that contains
// the dvdId for the given dvd.  We'll use that to retrieve the 
// dvd's details.
    var element = $(event.relatedTarget);
//grab the dvd id
    var dvdId = element.data('dvd-id');
    var modal = $(this);
// make an ajax call to get contact information for given dvd id
//this is a GET request to dvd/{id}
//upon success, put the returned JSON data into the data dialog
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (dvd) {

        modal.find('#dvd-id').text(dvd.dvdId);
        modal.find('#dvd-title').text(dvd.title);
        modal.find('#dvd-releaseYear').text(dvd.releaseYear);
        modal.find('#dvd-rating').text(dvd.rating);
        modal.find('#dvd-director').text(dvd.director);
        modal.find('#dvd-studio').text(dvd.studio);
        modal.find('#dvd-note').text(dvd.note);
    });
});
// This code runs in response to the show.bs.modal event - it gets the correct
// contact data and renders it to the dialog
$('#editModal').on('show.bs.modal', function (event) {
// Get the element that triggered this event - in our case it is a dvd
// title link in the summary table.  This link has an attribute that contains
// the dvdId for the given dvd.  We'll use that to retrieve the 
// dvd's details.
    var element = $(event.relatedTarget);
//grab the dvd id
    var dvdId = element.data('dvd-id');
    var modal = $(this);
// make ajax call for dvd JSON object
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (dvd) {

        modal.find('#dvd-id').text(dvd.serialNumber);
        modal.find('#edit-title').val(dvd.title);
        modal.find('#edit-year').val(dvd.releaseYear);
        modal.find('#edit-rating').val(dvd.rating);
        modal.find('#edit-director').val(dvd.director);
        modal.find('#edit-studio').val(dvd.studio);
        modal.find('#edit-note').val(dvd.note);
        modal.find('#edit-dvd-id').val(dvd.serialNumber);
    });
});
function deleteDVD(id) {
    var answer = confirm("Do you really want to delete this movie?");

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'dvd/' + id
        }).success(function () {
            loadContacts();
        });
    }
}
//var dummyDetailsDvd = {
//    dvdId: 4,
//    title: "Deadpool",
//    releaseYear: 2016,
//    rating: "R",
//    director: "Tim Miller",
//    studio: "Marvel Entertainment",
//    note: "Not family friendly..."
//};
//
//var dvd = {
//    dvdId: 4,
//    title: "Deadpool",
//    releaseYear: 2016,
//    rating: "R",
//    director: "Tim Miller",
//    studio: "Marvel Entertainment",
//    note: "Not family friendly..."
//};
