<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/6/14
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>细节</title>
    <script src="js/jquery.min.js"></script>
</head>
<body>
    <form action="update.do" method="post">
        <table style="position: absolute;left:300px;top:100px;">
            <tbody id="tbody">
            </tbody>
            <tr>
                <td><input type="button" value="提交" onclick="sub()"></td>
                <td><a href="index.jsp">点我去首页</a></td>
            </tr>
    </table>
    </form>
</body>
</html>
<script>
    $(function () {
        showdetail();
    })
    function showdetail(){
        $.get("showdetail.do",{id:${param.id}},function (data) {
           // console.log(data)
            var html="";
            html+="<tr>";
            html+="<td style='text-align: center'>"+data.title+"</td>";
            html+="</tr>";
            html+="<tr>";

            html+="<td><input type='hidden' name='sid' value='"+data.id+"'</td>";
            html+="</tr>";
            html+="<tr>";
            html+="<td style='text-align: center'>"+data.viewTimes+"人查看"+"共有"+data.totalVotes+"人投票"+"</td>";
            html+="</tr>";
            html+="<tr>";
            html+="<td>选项</td>"+"<td>票数"+"&nbsp;&nbsp;"+"比例</td>";
            html+="</tr>";
            //循环，第一个为循环的变量，第二个为函数，函数第一个参数为下标，第二个参数为当前循环变量
            $.each(data.options,function(index,op){
                html+="<tr>";

                html+="<td><input type='radio' name='id' value='"+op.id+"'>"+op.optContent+"</td>";
                html+="<td>"+op.vote+"&nbsp;&nbsp;&nbsp;"+(op.vote/data.totalVotes*100).toFixed(2)+"%</td>";
                html+="</tr>";
            });
            $("#tbody").html(html);
        });
    }
    function sub() {
        var ops=document.getElementsByName("id");

        var flag=0;
        for(i=0;i<ops.length;i++)
        {
            if(ops[i].checked==true)
            {
                flag=1;
                document.forms[0].submit();
            }
        }
        if(flag==0)
        {
            alert("请选择选项");
        }

    }
</script>
