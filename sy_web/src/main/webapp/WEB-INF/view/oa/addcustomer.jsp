<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}/${action}" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<p class="contentTitle">添加公司</p>
		<div class="pageFormContent" layoutH="98">
			
		<fieldset>
				<legend>基本信息</legend>
					<p>
						<label>公司名称：</label>
						<input name="cName" class="required" type="text" size="30"/>
					</p>
					
					<p>
						<label>招工信息：</label>
						<input name="cLuckyDay"  alt="例：加班多 18-40周岁 工资高" type="text" size="30"/>
					</p>
					<p>
						<label>岗位月薪：</label>
						<input name="cCapital"  type="text" size="30"/>
					</p>
					<p>
						<label>公司地址：</label>
						
						<input name="cArea" type="text" size="30" />
					</p>
					<p>
						<label>联系人：</label>
						<input type="text" size="30" name="cLinkman" />
					</p>
					<p>
						<label>手机号码：</label>
						<input  type="text" size="30" name="cMobile"/>
					</p>
					<p>
						<label>邮箱：</label>
						<input type="text" size="30" name="cMail"/>
					</p>
			</fieldset>
			<fieldset>
				<legend>公司主图</legend>
					<div class='image-item'>
								<span style='width: 200px;height: 200px;border: 1px #C4C4C4 solid; display: block; float: left; margin: 5px;'>
								<input type='file' name='uploadPic11' class='filePrew' id='uploadPic11' fileFormat='GIF,JPG,JPEG,PNG,BMP' onchange='uploadingMainImage(this)'  style='width: 65px;height: 27px; margin-left: 20px;'>
								<span style='width: 90%;height: 1px;display: block;border-top:1px dotted #C7C7C7; margin:auto;'></span>
								<span style='width:100%;height: 175px; display: block;'><img src='images/fm.png' class='img-rounded' style='width: 100%;height: 97%'/></span>
								</span>
					</div>
			</fieldset>
			<fieldset>
				<legend>岗位图片</legend>
					<div class='image-item'>
								<span style='width: 200px;height: 200px;border: 1px #C4C4C4 solid; display: block; float: left; margin: 5px;'>
								<input type='file' name='uploadPic10' class='filePrew' id='uploadPic10' fileFormat='GIF,JPG,JPEG,PNG,BMP' onchange='uploadingJobImage(this)'  style='width: 65px;height: 27px; margin-left: 20px;'>
								<span style='width: 90%;height: 1px;display: block;border-top:1px dotted #C7C7C7; margin:auto;'></span>
								<span style='width:100%;height: 175px; display: block;'><img src='images/fm.png' class='img-rounded' style='width: 100%;height: 97%'/></span>
								</span>
					</div>
					<div class='image-item'>
								<span style='width: 200px;height: 200px;border: 1px #C4C4C4 solid; display: block; float: left; margin: 5px;'>
								<input type='file' name='uploadPic20' class='filePrew' id='uploadPic20' fileFormat='GIF,JPG,JPEG,PNG,BMP' onchange='uploadingJobImage(this)'  style='width: 65px;height: 27px; margin-left: 20px;'>
								<span style='width: 90%;height: 1px;display: block;border-top:1px dotted #C7C7C7; margin:auto;'></span>
								<span style='width:100%;height: 175px; display: block;'><img src='images/fm.png' class='img-rounded' style='width: 100%;height: 97%'/></span>
								</span>
					</div>
					<div class='image-item'>
								<span style='width: 200px;height: 200px;border: 1px #C4C4C4 solid; display: block; float: left; margin: 5px;'>
								<input type='file' name='uploadPic30' class='filePrew' id='uploadPic30' fileFormat='GIF,JPG,JPEG,PNG,BMP' onchange='uploadingJobImage(this)'  style='width: 65px;height: 27px; margin-left: 20px;'>
								<span style='width: 90%;height: 1px;display: block;border-top:1px dotted #C7C7C7; margin:auto;'></span>
								<span style='width:100%;height: 175px; display: block;'><img src='images/fm.png' class='img-rounded' style='width: 100%;height: 97%'/></span>
								</span>
					</div>
			</fieldset>
			<fieldset>
				<legend>住宿信息</legend>
				<dl class="nowrap">
					<dt>位置：</dt>
					<dd><textarea name="cWeibo" cols="60" rows="1"></textarea></dd>
				</dl>
				
				<dl class="nowrap">
					<dt>环境：</dt>
					<dd><textarea name="cAddress" cols="60" rows="1"></textarea></dd>
				</dl>
				<dl class="nowrap">
					<dt>费用：</dt>
					<dd><textarea name="cSite" cols="60" rows="1"></textarea></dd>
				</dl>
				<dl class="nowrap">
					<dt>厂车：</dt>
					<dd><textarea name="cHotel" cols="60" rows="1"></textarea></dd>
				</dl>
				<dl class="nowrap">
					<dt>提示：</dt>
					<dd><textarea name="cWechat" cols="60" rows="1"></textarea></dd>
				</dl>
			</fieldset>
			<fieldset style="margin-top: 10px;" id="cptp">
				<legend>住宿图片(<font color="#09c">建议上传500像素*500像素的图片,大小500kb以内</font>)</legend>
				<div class="image-container">
					<!-- 显示图片 -->
				</div>
			</fieldset>
			<fieldset>
				<legend>伙食信息</legend>
				<dl class="nowrap">
					<dt>费用：</dt>
					<dd><textarea name="cQq" cols="60" rows="1"></textarea></dd>
				</dl>
				<dl class="nowrap">
					<dt>提示：</dt>
					<dd><textarea name="cTrde" cols="60" rows="1"></textarea></dd>
				</dl>
			</fieldset>
			
			<fieldset style="margin-top: 10px;" id="cptp">
				<legend>伙食图片(<font color="#09c">建议上传500像素*500像素的图片,大小500kb以内</font>)</legend>
				<div class="image-container-food">
					<!-- 显示图片 -->
				</div>
			</fieldset>
			
			<fieldset>
				<legend>薪资信息</legend>
				<dl class="nowrap">
					<dt>发薪方式：</dt>
					<dd><textarea name="cJob" cols="60" rows="1"></textarea></dd>
				</dl>
				<dl class="nowrap">
					<dt>工资计算：</dt>
					<dd><textarea name="cScale" cols="60" rows="1"></textarea></dd>
				</dl>
			</fieldset>
			<div class="divider"></div>
			<fieldset>
				<legend>公司简介</legend>
				<dl class="nowrap">
					<dt>公司简介：</dt>
					<dd><textarea name="cRemark" cols="60" rows="3"></textarea></dd>
				</dl>
			</fieldset>
		</div>
		<div class="formBar">
			<ul style="float: left;margin-left: 5px;">
				<li>
					<div class="buttonActive" style="display: inline;">
					 	<div class="buttonContent">
					 		<button type="button" onclick="addpic()">增加住宿图片</button>
					 	</div>
				 	</div>
				</li>
				<li>
					<div class="buttonActive" style="display: inline;">
					 	<div class="buttonContent">
					 		<button type="button" onclick="addpic2()">增加伙食图片</button>
					 	</div>
				 	</div>
				</li>
			</ul>
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
</body>
<script type="text/javascript">
//添加伙食图片
function addpic2(){
	/* 获取已经增加多少上传图片组件*/
	var fileCount = $(".image-container-food input:file").length+1;
	var imageCount = $('.image-container-food .image-item').size();
	if(imageCount < 10){
	/*增加图片组件*/
		$(".image-container-food").append(
				"<div class='image-item'>"+
					"<span style='width: 200px;height: 200px;border: 1px #C4C4C4 solid; display: block; float: left; margin: 5px;'>"+
					"<input type='file' name='uploadPic"+fileCount+"5' class='filePrew' id='uploadPic"+fileCount+"5' fileFormat='GIF,JPG,JPEG,PNG,BMP' onchange='uploadingFoodImage(this)'  style='width: 65px;height: 27px; margin-left: 20px;'>"+
					"<input type='button' value='删除' style='margin-left: 20px;width:65px;' onclick='removePic2(this)'>"+
					"<span style='width: 90%;height: 1px;display: block;border-top:1px dotted #C7C7C7; margin:auto;'></span>"+
					"<span style='width:100%;height: 175px; display: block;'><img src='images/fm.png' class='img-rounded' style='width: 100%;height: 97%'/></span>"+
					"</span>"+
				"</div>"
				);
	}else{
		 alert("最多添加十张图片");
	}
}
/*移除伙食图片*/
function removePic2(th) {
	$(th).parent().remove();
}

function uploadingFoodImage(th) {
	/* 验证是否是有效图片格式 */
	/* 上传图片 */
	var thisid = $(th).attr("id");
	$.ajaxFileUpload({
				url : "picupload?width=0&height=0",
				secureuri : false,
				fileElementId : thisid, //文件选择框的id属性（必须）
				dataType : 'text',
				data : {
					"updateP" : thisid
				},
				success : function(data, status) {
					var data = eval("(" + data + ")");
					if (data.state == 1)
						alert("图片格式不符，支持bmp、jgp、png、gif格式");
					else if (data.state == 2)
						alert("图片大小超过100K");
					else if (data.state == 3)
						alert("图片宽高不符合要求");
					else if (data.state == 4)
						alert("上传失败！");
					else if (data.updateP == thisid) {
						/* 增加img标签将图片显示出来 */
						$("#" + thisid).next().next().next().html("<img src='"+data.fileName+"' width='200px' height='170px'>");
						/*真正保存图片的地方*/
						$("#" + thisid).after("<input type='hidden' id='filename' name='foodimage' value='"+data.fileName+"'>");
						/* 上传完后不允许修改 */
						$("#" + thisid).attr("disabled", true);
					}
				},
				error : function() {
					alert("预览失败！");
				}
			});
}



function addpic(){
	/* 获取已经增加多少上传图片组件*/
	var fileCount = $(".image-container input:file").length+1;
	var imageCount = $('.image-container .image-item').size();
	if(imageCount < 10){
	/*增加图片组件*/
		$(".image-container").append(
				"<div class='image-item'>"+
					"<span style='width: 200px;height: 200px;border: 1px #C4C4C4 solid; display: block; float: left; margin: 5px;'>"+
					"<input type='file' name='uploadPic"+fileCount+"' class='filePrew' id='uploadPic"+fileCount+"' fileFormat='GIF,JPG,JPEG,PNG,BMP' onchange='uploadingImgageText(this)'  style='width: 65px;height: 27px; margin-left: 20px;'>"+
					"<input type='button' value='删除' style='margin-left: 20px;width:65px;' onclick='removePic(this)'>"+
					"<span style='width: 90%;height: 1px;display: block;border-top:1px dotted #C7C7C7; margin:auto;'></span>"+
					"<span style='width:100%;height: 175px; display: block;'><img src='images/fm.png' class='img-rounded' style='width: 100%;height: 97%'/></span>"+
					"</span>"+
				"</div>"
				);
	}else{
		 alert("最多添加十张图片");
	}
}


//验证上传图片的格式，大小及预览
$('.image-container').on('change','.image-item  .filePrew',function(e) {
		if (this.files[0].size > 3145728) {
			alert("图片大小不能超过3M");
		} else {
			var target = this;
			var name = target.value;
			var fileName = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
			var fileFormat = $(this).attr("fileFormat");
			var fileFormatArr = fileFormat.split(",");
			var isAllowed = 0;
			for ( var i = 0; i < fileFormatArr.length; i++) {
				if (fileName == fileFormatArr[i].toLowerCase().trim()) {
					isAllowed++;
				}
			}
			if (isAllowed > 0) {
				console.log(this.files[0]);
				$(this).parents(".image-item").find(".img-rounded").attr("src",window.URL.createObjectURL(this.files[0]));
			} else {
				alert("图片格式仅支持(" + fileFormat + ")!");
				target.value = "";
			}
		}
	});


/*移除图片*/
function removePic(th) {
	$(th).parent().remove();
}
//主图
function uploadingMainImage(th) {
	/* 验证是否是有效图片格式 */
	/* 上传图片 */
	var thisid = $(th).attr("id");
	$.ajaxFileUpload({
				url : "picupload?width=0&height=0",
				secureuri : false,
				fileElementId : thisid, //文件选择框的id属性（必须）
				dataType : 'text',
				data : {
					"updateP" : thisid
				},
				success : function(data, status) {
					var data = eval("(" + data + ")");
					if (data.state == 1)
						alert("图片格式不符，支持bmp、jgp、png、gif格式");
					else if (data.state == 2)
						alert("图片大小超过100K");
					else if (data.state == 3)
						alert("图片宽高不符合要求");
					else if (data.state == 4)
						alert("上传失败！");
					else if (data.updateP == thisid) {
						/* 增加img标签将图片显示出来 */
						$("#" + thisid).next().next().html("<img src='"+data.fileName+"' width='200px' height='170px'>");
						/*真正保存图片的地方*/
						$("#" + thisid).after("<input type='hidden' id='cBirth' name='cBirth' value='"+data.fileName+"'>");
						/* 上传完后不允许修改 */
						$("#" + thisid).attr("disabled", true);
					}
				},
				error : function() {
					alert("预览失败！");
				}
			});
}
//岗位图片
function uploadingJobImage(th) {
	/* 验证是否是有效图片格式 */
	/* 上传图片 */
	var thisid = $(th).attr("id");
	alert(thisid);
	$.ajaxFileUpload({
				url : "picupload?width=0&height=0",
				secureuri : false,
				fileElementId : thisid, //文件选择框的id属性（必须）
				dataType : 'text',
				data : {
					"updateP" : thisid
				},
				success : function(data, status) {
					var data = eval("(" + data + ")");
					if (data.state == 1)
						alert("图片格式不符，支持bmp、jgp、png、gif格式");
					else if (data.state == 2)
						alert("图片大小超过100K");
					else if (data.state == 3)
						alert("图片宽高不符合要求");
					else if (data.state == 4)
						alert("上传失败！");
					else if (data.updateP == thisid) {
						/* 增加img标签将图片显示出来 */
						$("#" + thisid).next().next().html("<img src='"+data.fileName+"' width='200px' height='170px'>");
						/*真正保存图片的地方*/
						$("#" + thisid).after("<input type='hidden' id='jobimage' name='jobimage' value='"+data.fileName+"'>");
						/* 上传完后不允许修改 */
						$("#" + thisid).attr("disabled", true);
					}
				},
				error : function() {
					alert("预览失败！");
				}
			});
}
//住宿图片
function uploadingImgageText(th) {
	/* 验证是否是有效图片格式 */
	/* 上传图片 */
	var thisid = $(th).attr("id");
	alert(thisid);
	$.ajaxFileUpload({
				url : "picupload?width=0&height=0",
				secureuri : false,
				fileElementId : thisid, //文件选择框的id属性（必须）
				dataType : 'text',
				data : {
					"updateP" : thisid
				},
				success : function(data, status) {
					var data = eval("(" + data + ")");
					if (data.state == 1)
						alert("图片格式不符，支持bmp、jgp、png、gif格式");
					else if (data.state == 2)
						alert("图片大小超过100K");
					else if (data.state == 3)
						alert("图片宽高不符合要求");
					else if (data.state == 4)
						alert("上传失败！");
					else if (data.updateP == thisid) {
						/* 增加img标签将图片显示出来 */
						$("#" + thisid).next().next().next().html("<img src='"+data.fileName+"' width='200px' height='170px'>");
						/*真正保存图片的地方*/
						$("#" + thisid).after("<input type='hidden' id='filename' name='filename' value='"+data.fileName+"'>");
						/* 上传完后不允许修改 */
						$("#" + thisid).attr("disabled", true);
					}
				},
				error : function() {
					alert("预览失败！");
				}
			});
}

</script>

