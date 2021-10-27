<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Welcome to My Lab</title>
  </head>
  <body> 
  <div style="margin: 20px; ">
   <div style="background: bisque; padding: 2px;text-align: center;">
     <h1 class="display-4">My Lab Notepad</h1>
    </div>
 
	<form method="post" action="Search" modelAttribute="notes">
	  <div class="form-group">
	    <label>Enter your lab entry here:</label>
	    <div style="margin: 12px; outline: 10px solid #e8b353;">
	      <textarea class="form-control z-depth-1" id="notes" rows="10" name="notes">${notes.text}</textarea> 
	    </div>
	    <div class="form-group mb-2"> 
		    <label>Word to be searched:</label> 
		    <input type="text"  name="searchKey" value="${searchKey}"/>
		    <button type="submit" class="btn btn-primary btn-lg">Search</button>
		</div>
	  </div>
	</form>
	<h3>Search Results</h3>
    Words Found: ${results.wordsFound}
    <br/>
    Similar Words: ${results.similarWords}
  </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>