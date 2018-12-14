<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
   <form action="update" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/><br />
       <input type="submit" value="上传"/>
   </form>
        <a href="downLoad?filename=timg.jpg">下载</a>
</body>
</html>
