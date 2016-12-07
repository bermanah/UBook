<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>UBook_Home</title>
        <link rel="stylesheet" type="text/css" href="style.css"></link>
        <script src="//code.jquery.com/jquery.min.js"></script>
        <jsp:include page="navBar.jsp" />
        
    </head>
    
    <body>
        <p>
            <img src="images/Logo_withBook.png" class="centerImage"alt="Logo" />
        </p>
        
        <form method="post" action="results.jsp" id="myform" align="center">
            <p> 
                <label>ISBN:
                    <input type="text" id="isbn" name="isbn" size="30"/>
                </label>
            </p>
            
            <p> 
                <input type="submit" name="Search" value="Search" id="search" />
            </p>
        </form>
    </body>
</html>
