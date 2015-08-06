<%@ include file="/WEB-INF/view/includes.jsp"%>
<%@ include file="/WEB-INF/view/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span9">
			<form:form modelAttribute="task" method="POST" class="form-horizontal">
			
			<div class="control-group">
				<label class="control-label" for="url">NO:</label>
				<div class="controls">
					<form:input path="id" size="30" maxlength="80"/>
				</div>
			</div>	
			
			<div class="control-group">
				<label class="control-label" for="title">タイトル</label>
				<div class="controls">
					<form:input path="title" size="30" maxlength="80"/>
				</div>
			</div>
			<br>
		   <button type="submit" class="btn btn-primary">保存</button>
		   </form:form>		
		</div>
	</div>
</div>		
<!--/.fluid-container-->
<%@ include file="/WEB-INF/view/footer.jsp"%>