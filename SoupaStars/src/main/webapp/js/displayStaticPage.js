/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var url = window.location.pathname;
var urlSplit = url.split("displayStaticPage");
var id = urlSplit[1];

$(document).ready(function () {
    loadPage();
});

function loadPage() {
   
    

    $.ajax({
        url: 'staticPage/' + id
    }).success(function (data, status) {
        fillPageInfo(data, status);
    });
}

function fillPageInfo(page, status) {
    document.getElementById("pageTitle").innerHTML = page.title;
    document.getElementById("pageInfo").innerHTML = '<span class="glyphicon glyphicon-user"></span><a href="#"> ' + page.author + ' </a>&nbsp;';        
    document.getElementById("pageBody").innerHTML = page.body;
    
}



