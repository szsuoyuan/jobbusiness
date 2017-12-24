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
				<legend>住宿信息</legend>
			<p>
				<label>位置：</label>
				<input type="text" size="30" name="cWeibo"/>
			</p>
			<p>
				<label>环境：</label>
				<input type="text" size="30" name="cAddress"/>
			</p>
			<p>
				<label>费用：</label>
				<input type="text" size="30" name="cSite" />
			</p>
			<p>
				<label>厂车：</label>
				<input type="text" size="30" name="cHotel" />
			</p>
			<p>
				<label>提示：</label>
				<input type="text" size="30" name="cWechat" />
			</p>
			</fieldset>
			<fieldset style="margin-top: 10px;" id="cptp">
				<legend>住宿图片(<font color="#09c">建议上传500像素*500像素的图片,大小500kb以内</font>)</legend>
				<div class="image-container">
					<!-- 显示图片 -->
				</div>
			</fieldset>
			<fieldset>
				<legend>伙食信息</legend>
			<p>
				<label>费用：</label>
				<input type="text" size="30" name="cQq"/>
			</p>
			<p>
				<label>提示：</label>
				<input type="text" size="30" name="cTrde"/>
			</p>
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
<<script type="text/javascript">
function addpic(){
	/* 获取已经增加多少上传图片组件*/
	var fileCount = $(".image-container input:file").length+1;
	var imageCount = $('.image-container .image-item').size();
	if(imageCount < 10){
	/*增加图片组件*/
		$(".image-container").append(
				"<div class='image-item'>"+
					"<span style='width: 200px;height: 200px;border: 1px #C4C4C4 solid; display: block; float: left; margin: 5px;'>"+
					"<input type='file' name='uploadPic' class='filePrew' id='uploadPic' fileFormat='GIF,JPG,JPEG,PNG,BMP' style='width: 65px;height: 27px; margin-left: 20px;'>"+
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
/*移除图片*/
function removePic(th) {
	$(th).parent().remove();
}
</script>

