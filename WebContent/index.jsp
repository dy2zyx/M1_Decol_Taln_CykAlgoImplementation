<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.yudu.cyk.*" %>	
<html>
<head>
<style type="text/css">
body {
    font: 13px 'Lucida sans', Arial, Helvetica;
    color: #eee;
    text-align: center;
    background-size:10px;
   }
.form-wrapper {
	width: 450px;
    padding: 8px;
    margin: 100px auto;
    overflow: hidden;
    border-width: 1px;
    border-style: solid;
    border-color: #dedede #bababa #aaa #bababa;
    box-shadow: 0 3px 3px rgba(255,255,255,.1), 0 3px 0 #bbb, 0 4px 0 #aaa, 0 5px 5px #444;
    border-radius: 10px;    
    background-color: #f6f6f6;
    background-image: linear-gradient(top, #f6f6f6, #eae8e8);
	}
.form-wrapper #query {
    width: 330px;
    height: 20px;
    padding: 10px 5px;
    float: left;    
    font: bold 16px 'lucida sans', 'trebuchet MS', 'Tahoma';
    border: 1px solid #ccc;
    box-shadow: 0 1px 1px #ddd inset, 0 1px 0 #fff;
    border-radius: 3px;      
}
.form-wrapper #query:focus {
    outline: 0; 
    border-color: #aaa;
    box-shadow: 0 1px 1px #bbb inset;  
}
.form-wrapper #query::-webkit-input-placeholder {
   color: #999;
   font-weight: normal;
}
.form-wrapper #query:-moz-placeholder {
    color: #999;
    font-weight: normal;
}

.form-wrapper #query:-ms-input-placeholder {
    color: #999;
    font-weight: normal;
}
.form-wrapper #submit {
    float: right;    
    border: 1px solid #00748f;
    height: 42px;
    width: 100px;
    padding: 0;
    cursor: pointer;
    font: bold 15px Arial, Helvetica;
    color: #fafafa;
    text-transform: uppercase;    
    background-color: #0483a0;
    background-image: linear-gradient(top, #31b2c3, #0483a0);
    -moz-border-radius: 3px;
    -webkit-border-radius: 3px;
    border-radius: 3px;      
    text-shadow: 0 1px 0 rgba(0, 0 ,0, .3);
    box-shadow: 0 1px 0 rgba(255, 255, 255, 0.3) inset, 0 1px 0 #fff;
}
  
.form-wrapper #submit:hover,
.form-wrapper #submit:focus {       
    background-color: #31b2c3;
    background-image: linear-gradient(top, #0483a0, #31b2c3);
}   
  
.form-wrapper #submit:active {
    outline: 0;    
    box-shadow: 0 1px 4px rgba(0, 0, 0, 0.5) inset;    
}
  
.form-wrapper #submit::-moz-focus-inner {
    border: 0;
}
			
	
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#query').blur(function(event) {
            var query = $('#query').val();
            $.get('CykServlet', {
                    query : query
            }, function(responseText) {
                    $('#ajaxResponse').text(responseText);
            });
    });
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application d'implémentation du l'algorithme CYK</title>
</head>
<body style="background:url('C:/Users/Administrator/Desktop/S2/TALN/cyk.jpg');">
	
	<div id="search_bar">
		<form action="http://localhost:8080/cyk/query" method="get" class="form-wrapper">
			<input type="text"  placeholder="Saisir votre phrase" id="query" name="query" />	
			<input type="submit" id="submit" value="GO" />
    		<div id="ajaxResponse"></div>	
		</form>
	</div>
</body>
</html>