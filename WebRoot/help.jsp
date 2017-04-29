<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">、
</head>

<script type="text/JavaScript" src="${baseurl}js/pdfobject.js"></script>
<script type="text/javascript">
    window.onload = function (){
        var success = new PDFObject({ url: "help.pdf" ,pdfOpenParams: { scrollbars: '0', toolbar: '0', statusbar: '0'}}).embed("pdf1");
    };
</script>
<title>帮助</title>
<style>
    html, body {
        height: 100%;
        width: 100%;
        margin: 0;
        padding: 0;
    }

    body {
        width: 100%;
        height: 100%;
        background-size: 100% 100%;
    }
</style>
<body>
<div id="pdf1" style="width:100%; height:100%;">I <a href="~/pdf/CGVET22-08-2011V2P.pdf">Click here to download the PDF</a></div>
</body>
</html>