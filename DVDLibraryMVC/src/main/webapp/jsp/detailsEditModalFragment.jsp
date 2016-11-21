<%-- 
    Document   : detailsEditModalFragment
    Created on : Nov 2, 2016, 3:20:47 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade" id="detailsModal" tabindex="-1" role="dialog"
     aria-labelledby="detailsModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="detailsModalLabel">Movie Details</h4>
            </div>
            <div class="modal-body">
                <h3 id="dvd-id"></h3>
                <table class="table table-bordered">
                    <tr>
                        <th>Title:</th>
                        <td id="dvd-title"></td>
                    </tr>
                    <tr>
                        <th>Release Year:</th>
                        <td id="dvd-releaseYear"></td>
                    </tr>
                    <tr>
                        <th>Rating:</th>
                        <td id="dvd-rating"></td>
                    </tr>
                    <tr>
                        <th>Director:</th>
                        <td id="dvd-director"></td>
                    </tr>
                    <tr>
                        <th>Studio:</th>
                        <td id="dvd-studio"></td>
                    </tr>
                    <tr>
                        <th>Note:</th>
                        <td id="dvd-note"></td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    Close
                </button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
     aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="editModalLabel">Edit Movie</h4>
            </div>
            <div class="modal-body">
                <h3 id="dvd-id"></h3>
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="edit-title" 
                               class="col-md-4 control-label">Title:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control"
                                   id="edit-title" 
                                   name="title"
                                   placeholder="Title" required />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-year" 
                               class="col-md-4 control-label">Release Year:</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control"
                                   id="edit-year" 
                                   name="year"
                                   max = "2030"
                                   placeholder="2016" required/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-rating" 
                               class="col-md-4 control-label">MPAA Rating:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control"
                                   id="edit-rating" 
                                   name="rating"
                                   placeholder="PG-13" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-director" 
                               class="col-md-4 control-label">Director:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control"
                                   id="edit-director" 
                                   name="director"
                                   placeholder="Director" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-studio" 
                               class="col-md-4 control-label">Studio:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control"
                                   id="edit-studio" 
                                   name="studio"
                                   placeholder="Studio" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-note" 
                               class="col-md-4 control-label">Note:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control"
                                   id="edit-note" 
                                   name="note"
                                   placeholder="Personal Note" />
                            <input type="hidden" id="edit-dvd-id">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="edit-button"
                                    class="btn btn-default" data-dismiss="modal">Submit Changes</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">
                                Cancel</button>                              
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>   
