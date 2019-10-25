

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style><%@include file="/css/style.css"%></style>
        <link rel="shortcut icon" href="https://i.ibb.co/pRFSF1V/cfdea513-2b2a-4df2-b307-994d27dab241-200x200.png" type="image/x-icon">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>File Handling Page</title>
    </head>

    <body>
        <div id="page-container">
            <div class="bg">

                <h1 class="display-4">File Handling Page
                    <br><span class="text-muted">Now uploading and downloading your files comes easy and fast</span>
                </h1>

                <div class="page">

                    <div class="container border up col-8" id="main">

                        <div class="row">
                            <div class="col-4">
                                <form method="post" id="myform" action="UploadServlet" enctype="multipart/form-data" onSubmit="return validate();  ">
                                    <h5>File Uploader</h5>
                                    <input name="myfile" type="file" multiple id="file"/>
                                    <br>
                                    <br>                      
                                    <input type="submit" class="btn btn-primary" id="submit" disabled="true">
                                    <br>     
                                </form>
                            </div>
                            <div class="col-8 pull-right">
                                <img src='<c:url value="https://www.freeiconspng.com/uploads/upload-icon-31.png"></c:url>' width="110" class="float-right"/> 
                                </div>
                        </div>

                    </div>

                    <div class="col-12" id="large">
                            
                        <div class="col-2" id="empty">       
                        </div>

                        <div class="container border down col-8" id="main">

                            <h5>File Downloader</h5>
                            <c:choose>
                                <c:when test = "${requestScope.myfiles.size()>0}">

                                    <table class="table table-stripped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th scope="col" class="text-center">#</th>
                                                <th scope="col" class="text-center">File id</th>
                                                <th scope="col" class="text-center">Type</th>
                                                <th scope="col" class="text-center">File name</th>
                                                <th scope="col" class="text-center">Download</th>
                                                <th scope="col"  class="text-center">Delete</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var = "i" items = "${requestScope.myfiles}">
                                                <tr>
                                                    <th scope="row" class="text-center">${requestScope.myfiles.indexOf(i)+1}</th>
                                                    <td class="text-center"> <c:out value = "${i.getId()}"/> </td> 
                                                    <td class="text-center type"></td> 
                                                    <td class="text-center" style="overflow:hidden"> <c:out value = "${i.getFilename()}"/> </td> 
                                                    <td class="text-center"> <a href="DownloadServlet?id=${i.getId()}" download=""> <i class="fas fa-cloud-download-alt"></i> <a> </td>
                                                    <td class="text-center"> <a href="DeleteAFile?id=${i.getId()}" onclick="return confirm('Are you sure you want to delete the file?')"> <i class="fas fa-trash-alt"></i> <a> </td> 
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table> 

                                </c:when>
                                <c:otherwise>
                                    <span class="text-muted">No files uploaded</span>
                                </c:otherwise>                         
                            </c:choose>
                        </div>
                            
                        <div class="col-2" id="icons">
                            <div class="container">
                                <div class="row">
                                    <div class="col-12 text-center">
                                        <a class="fb-ic" href="">
                                            <i class="fab fa-facebook-f fa-md fa-3x"> </i>
                                        </a>
                                        <a class="tw-ic" href="">
                                            <i class="fab fa-twitter fa-md fa-3x"> </i>
                                        </a>
                                        <a class="ins-ic" href="">
                                            <i class="fab fa-instagram fa-md fa-3x"> </i> 
                                        </a>
                                        <img id="logo" src="https://i.imgur.com/cCfaBzj.png">
                                    </div>
                                </div>
                            </div>  
                        </div>
                        
                        
                    </div>
                                
                </div> 
                                
            </div>
        </div>
                                
        <footer class="page-footer" id="footer">
            <div class="container">
                <div class="row">
                    <div class="col-12 text-center">
                        <span>© 2019 Copyright: FHP</span> <img id="footer_logo" src="https://i.ibb.co/YT4X4mv/a7e99b90-4dbe-48b4-8ad5-69318c953366-200x200.png"/>
                    </div>
                </div>
            </div>  
        </footer>

        <scripts>
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>      
            <script src="https://kit.fontawesome.com/52e2938880.js" crossorigin="anonymous"></script>
            <script src="js/custom.js" type="text/javascript"></script>
        </scripts>

    </body>
</html>



