/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//$(function () {
//
//    $("#searchTerm").autocomplete({
//        source: function (request, response) {
//            $.ajax({
//                url: "SearchController/search/" + $("#searchTerm").val(),
//                type: "POST",
//                dataType: "json",
//                success: function (data) {
//                    if (typeof Array.prototype.forEach !== 'function') {
//                        Array.prototype.forEach = function (callback) {
//                            for (var i = 0; i < this.length; i++) {
//                                callback.apply(this, [this[i], i, this]);
//
//                            }
//                        };
//
//                    }
//
//                    var values = data;
//                    var newArray = new Array(values.length);
//                    var i = 0;
//                    values.forEach(function (entry) {
//                        var newObject = {
//                            label: entry.title
//                        };
//                    newArray[i] = newObject;
//                        i++;
//                    });
//                    response(newArray);
//                    
//                }
//                
//            });
//            
//        },
//        minLength: 0
//    });
//
//});

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
                    newArray[i] = newObject;
                        i++;
                    });
                    response(newArray);
                    
                }
                
            });
            
        },
        minLength: 0
    });

});



        
    