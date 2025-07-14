<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Read Page</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

       <form role="form" action="/board/register" method="post"> 
       
         <div class="form-group">
            <label>Bno</label> <input class="form-control" name='bno'
            value='<c:out value="${board.bno}"/>' readonly="readonly">
          </div>
          
          <div class="form-group">
            <label>Title</label> <input class="form-control" name='title'
            value='<c:out value="${board.title}"/>'>
          </div>

          <div class="form-group">
            <label>Text area</label>
            <textarea class="form-control" rows="3" name='content' ><c:out value="${board.content}" />
            </textarea>
          </div>

          <div class="form-group">
            <label>Writer</label> <input class="form-control" name='writer'
            value='<c:out value="${board.writer}"/>'>
          </div>
          <button type = "submit" data-oper='modify' class="btn btn-default">수정하기</button>
          <button type = "submit" data-oper='remove' class="btn btn-default">삭제하기</button>
          <button type = "submit" data-oper='list' class="btn btn-default">목록으로</button>
          <!-- js를 이용해서 submit버튼의 data-oper 값에 따라 분기 설정함. -->
       </form>

      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp"%>

<script type = "text/javascript">
${document}.ready(function(){
   var formObj = $("form"); //위의 폼태그를 변수에 넣는다.
   $('button').on("click", fuction(e){
      e.preventDefault(); //기존의 세팅된 기능을 사용하지 않겠다. 
      //버튼을 눌러도 action = "/board/modify" method = "post" 기능 사용하지 않음 
      var operation = $(this).data("oper");
      //modify ||remove || list
      
      console.log(operation); //크롬브라우저 콘솔에 갓이 찍힘.
      
      if (operation==='remove') {
         fomrObj.attr("action","/board/remove")
      }else if (operation==='list') {
         self.location= "/board/list";
      }
      //modify는 기본 액션태그 내용대로 진행된다.
      
      formObj.submit(); //submit버튼 동작 시작!!
   
   })
})</script>