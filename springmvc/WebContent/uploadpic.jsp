<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>html5实现上传</title>
    <style type="text/css">
        #result{
            width: 200px;
            height:112px;
            border:1px solid #eee;
        }
        #result img{
            width: 200px;
        }
        input{
            width: 70px;
            margin-top: 10px;
        }
        @-moz-document url-prefix() { input { width:65px; } }/*单独对火狐进行设置*/
    </style>
</head>
<body>
    <div id = "result"></div>
    <input id="pic" type="file" name = 'pic' accept = "image/*" onchange = "selectFile()"/>
    <button onclick = "handIn()">提交</button>
    <script type="text/javascript">
        //var files = document.getElementById('pic').files;
        var form = new FormData();//通过HTML表单创建FormData对象
        var url = 'http://127.0.0.1:8080/'
        function selectFile(){
            var files = document.getElementById('pic').files;
            console.log(files[0]);
            if(files.length == 0){
                return;
            }
            var file = files[0];
            //把上传的图片显示出来
            var reader = new FileReader();
            // 将文件以Data URL形式进行读入页面
            console.log(reader);
            reader.readAsBinaryString(file);
            reader.onload = function(f){
                var result = document.getElementById("result");
                var src = "data:" + file.type + ";base64," + window.btoa(this.result);
                result.innerHTML = '<img src ="'+src+'"/>';
            }
            console.log('file',file);
            ///////////////////
            form.append('file',file);
            console.log(form.get('file'));
        }
        var xhr = new XMLHttpRequest();
        function handIn(){
         console.log(form.get('file'));
         xhr.open("post", url, true);
         xhr.addEventListener("readystatechange", function() {  
            var result = xhr;  
             if (result.status != 200) { //error  
                 console.log('上传失败', result.status, result.statusText, result.response);  
             }   
             else if (result.readyState == 4) { //finished  
                 console.log('上传成功', result);  
             }  
         });   
        }
    </script>
</body>

</html>

