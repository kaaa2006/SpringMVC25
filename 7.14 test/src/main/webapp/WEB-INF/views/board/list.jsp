<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">게시판</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                MBCBoard List Page
                <button id="regBtn" type="button" class="btn btn-xs pull-right">게시글등록</button>
            </div>

            <div class="panel-body">
                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <thead>
                        <tr>
                            <th>#번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="board">
                            <tr>
                                <td><c:out value="${board.bno}" /></td>
                                <td>
                                    <a href="/board/get?bno=${board.bno}">
                                        <c:out value="${board.title}" />
                                    </a>
                                </td>
                                <td><c:out value="${board.writer}" /></td>
                                <td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" /></td>
                                <td><fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <!-- 모달창 -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">MBC Board</h4>
                            </div>
                            <div class="modal-body">
                                처리가 완료되었습니다.
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                                <button type="button" class="btn btn-primary">저장(적용)</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 모달창 끝 -->

            </div>
        </div>
    </div>
</div>

<%@ include file="../includes/footer.jsp" %>

<!-- JavaScript -->
<script type="text/javascript">
    $(document).ready(function() {
        var result = '<c:out value="${result}" />';

        if (result === 'success') {
            $(".modal-body").html("처리가 완료되었습니다.");
            $("#myModal").modal("show");
        } else if (!isNaN(result) && parseInt(result) > 0) {
            $(".modal-body").html("게시글 " + parseInt(result) + "번이 등록 되었습니다.");
            $("#myModal").modal("show");
        }

        $("#regBtn").on("click", function() {
            self.location = "/board/register";
        });
    });
</script>
