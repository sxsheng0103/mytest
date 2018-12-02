<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
</head>
<body>
	<form id="form" method="post" action="/springmvc/form/imgUpload.do" enctype="multipart/form-data"> 
  		<input type="file" id="file" name="filename" style="display:true;" onchange="filechange(event)">
   		<!--修改，这里如果不用onchange，会出现一个小bug,当你提交后，图片只能变一次-->
		<img src="" width="200px" height="200px" id="img-change">
		<input type="submit" id="btn">保存图片</input>
		
    </form>  
</body>
<script type="text/javascript">
$("#img-change").click(function () {
    $("#file").click();
})



/*$("#file").change(function (event) {*/
var filechange=function(event){
    var files = event.target.files, file;
    if (files && files.length > 0) {
        // 获取目前上传的文件
        file = files[0];// 文件大小校验的动作
        if(file.size > 1024 * 1024 * 2) {
            alert('图片大小不能超过 2MB!');
            return false;
        }
        // 获取 window 的 URL 工具
        var URL = window.URL || window.webkitURL;
        // 通过 file 生成目标 url
        var imgURL = URL.createObjectURL(file);
        //用attr将img的src属性改成获得的url
        $("#img-change").attr("src",imgURL);
        // 使用下面这句可以在内存中释放对此 url 的伺服，跑了之后那个 URL 就无效了
        // URL.revokeObjectURL(imgURL);
    }
};

 

 /* $("form").submit(function () {
	var  url  ="/springmvc/form/imgUpload";
	console.info(url);
	console.info(this); */
	/* $.ajaxFileUpload({
        url: '/springmvc/form/imgUpload',
        fileElementId:'file',
        dataType:'txt',
        secureuri : false,
        success: function (data){
            if(data=="yes"){
                $("#img-alert").css("display","block");
            }
        },
        error:function(data,status,e){
            alert(e);
        }
    }); */
   /*  var fileObj = document.getElementById("file").files[0];
    var formFile = new FormData();
    formFile.append("filename", fileObj); //加入文件对象 
    formFile.append("a", "1122");
    
    if(formFile.has("b")){  
    	 alert(1);
    }
    console.info(formFile.getAll("a"));
    console.info(formFile.getAll("file"));
    var  data  = formFile;
    $.ajax({
        url: this.action,
        data: formFile,
        type: "post",
        dataType: "json",
        cache: false,//上传文件无需缓存
        processData: false,//用于对data参数进行序列化处理 这里必须false
        contentType: false, //必须
        success: function (result) {
            alert("上传完成!");
        },
    })
});  */
</script>
</html>

