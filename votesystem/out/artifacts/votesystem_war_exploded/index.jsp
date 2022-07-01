<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/6/14
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>投票系统首页</title>
    <script src="js/jquery.min.js"></script>
  </head>
  <body>

    <h1>全部主题 >></h1>
    <table border="1" width="700">
      <thead>
      <tr>
        <th>序号</th>
        <th>主题</th>
        <th>投票/查看</th>
        <th>创建时间</th>
      </tr>
      </thead>
      <tbody id="tbody">
      </tbody>
    </table>

  </body>
</html>
<script>
  $(function(){
    //初始化
    show();
  });
  function show(){
    $.get("show.do",function (data) {
      var html="";
      //循环，第一个为循环的变量，第二个为函数，函数第一个参数为下标，第二个参数为当前循环变量
      $.each(data,function(index,sub){
        html+="<tr>";
        html+="<td>"+sub.id+"</td>";
        html+="<td><a href='javaScript:showdetail("+sub.id+")'> "+sub.title+"</a></td>";
        html+="<td>"+sub.totalVotes+"/"+sub.viewTimes+"</td>";
        var date=new Date(sub.createDate);
        html+="<td>"+date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+"</td>";
        html+="</tr>";
      });
      $("#tbody").html(html);
    });
  }
  function showdetail(id) {
      location.href="detail.jsp?id="+id;
  }



</script>
