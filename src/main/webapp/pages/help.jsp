<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>OA系统帮助文档</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/popper.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script>
        $(function () {
           $("p").addClass("text-secondary");
        });
    </script>
</head>

<body STYLE="background-color: #c8cbcf;">

<div style="position: fixed;width: 100%;background-color:#5a6268">
    <h2 class="text-center">《OA系统帮助手册》</h2>
</div>
<div style="width: 65px;position: fixed;bottom: 25px;right: 25px;font-size:25px;z-index: 100;">
<a class="btn btn-outline-dark" href="#top">返回<br/>顶部</a>
</div>

<%--目录--%>
<div style="margin-left: 100px">
    <br/><br/>
    <h5><a class="btn-outline-dark" href="#c1">1  登录和登出</a><br/></h5>
    <h6><a class="btn-outline-dark" href="#c1-1">&nbsp;&nbsp;&nbsp;&nbsp;1-1  登录</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c1-2">&nbsp;&nbsp;&nbsp;&nbsp;1-2  登出</a><br/></h6>

    <h5><a class="btn-outline-dark" href="#c2">2  个人中心</a><br/></h5>
    <h6><a class="btn-outline-dark" href="#c2-1">&nbsp;&nbsp;&nbsp;&nbsp;2-1  查看个人信息</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c2-2">&nbsp;&nbsp;&nbsp;&nbsp;2-2  修改个人信息</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c2-3">&nbsp;&nbsp;&nbsp;&nbsp;2-3  修改密码</a><br/></h6>

    <h5><a class="btn-outline-dark" href="#c3">3  流程中心</a><br/></h5>
    <h6><a class="btn-outline-dark" href="#c3-1">&nbsp;&nbsp;&nbsp;&nbsp;3-1  发起请假流程</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c3-2">&nbsp;&nbsp;&nbsp;&nbsp;3-2  发起报销流程</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c3-3">&nbsp;&nbsp;&nbsp;&nbsp;3-3  发起调薪流程</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c3-4">&nbsp;&nbsp;&nbsp;&nbsp;3-4  发起用印流程</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c3-5">&nbsp;&nbsp;&nbsp;&nbsp;3-5  查看请假流程</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c3-6">&nbsp;&nbsp;&nbsp;&nbsp;3-6  查看报销流程</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c3-7">&nbsp;&nbsp;&nbsp;&nbsp;3-7  查看调薪流程</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c3-8">&nbsp;&nbsp;&nbsp;&nbsp;3-8  查看用印流程</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c3-9">&nbsp;&nbsp;&nbsp;&nbsp;3-9  查看流程图</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c3-10">&nbsp;&nbsp;&nbsp;&nbsp;3-10  领取流程任务</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c3-11">&nbsp;&nbsp;&nbsp;&nbsp;3-11  审批流程任务</a><br/></h6>

    <h5><a class="btn-outline-dark" href="#c4">4  消息中心</a><br/></h5>
    <h6><a class="btn-outline-dark" href="#c4-1">&nbsp;&nbsp;&nbsp;&nbsp;4-1  发送消息</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c4-2">&nbsp;&nbsp;&nbsp;&nbsp;4-2  发送公告</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c4-3">&nbsp;&nbsp;&nbsp;&nbsp;4-3  查看消息列表</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c4-4">&nbsp;&nbsp;&nbsp;&nbsp;4-4  查看消息详情</a><br/></h6>

    <h5><a class="btn-outline-dark" href="#c5">5  文件中心</a><br/></h5>
    <h6><a class="btn-outline-dark" href="#c5-1">&nbsp;&nbsp;&nbsp;&nbsp;5-1  上传文件</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c5-2">&nbsp;&nbsp;&nbsp;&nbsp;5-2  下载文件</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c5-3">&nbsp;&nbsp;&nbsp;&nbsp;5-3  查找文件</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c5-4">&nbsp;&nbsp;&nbsp;&nbsp;5-4  删除文件</a><br/></h6>

    <h5><a class="btn-outline-dark" href="#c6">6  管理员板块</a><br/></h5>
    <h6><a class="btn-outline-dark" href="#c6-1">&nbsp;&nbsp;&nbsp;&nbsp;6-1  员工管理</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c6-2">&nbsp;&nbsp;&nbsp;&nbsp;6-2  小组管理</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c6-3">&nbsp;&nbsp;&nbsp;&nbsp;6-3  流程管理</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c6-4">&nbsp;&nbsp;&nbsp;&nbsp;6-4  公告管理</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c6-5">&nbsp;&nbsp;&nbsp;&nbsp;6-5  文件管理</a><br/></h6>

    <h5><a class="btn-outline-dark" href="#c7">7  初始数据</a><br/></h5>
    <h6><a class="btn-outline-dark" href="#c7-1">&nbsp;&nbsp;&nbsp;&nbsp;7-1  初始用户数据</a><br/></h6>
    <h6><a class="btn-outline-dark" href="#c7-2">&nbsp;&nbsp;&nbsp;&nbsp;7-2  初始用户组数据</a><br/></h6>
</div>

<%--详细内容--%>
<div style="margin: 100px">
    <%--第一部分--%>
    <div>
        <h4 id="c1">1  登录和登出</h4>
        <h5 id="c1-1">1-1  登录</h5>
            <p>在登录页面中输入用户名和密码即可登录系统。此系统不支持用户自己注册，一切添加用户行为由HR操作。</p>
        <h5 id="c1-2">1-2  登出</h5>
            <p>登录后的主界面上方导航栏中由登出按钮。点击后即可登出，并返回登录界面。</p>
    </div>
        <br/>
    <%--第二部分--%>
    <div>
        <h4 id="c2">2  个人中心</h4>
        <h5 id="c2-1">2-1  查看个人信息</h5>
            <p>用户登录后会直接跳转到用户的个人信息界面，用户也可以手动选择左侧菜单“个人中心--查看个人信息”进入用户信息界面。
                用户在该界面可以查看自己所属小组、自己的职位、邮箱、年龄等信息</p>
        <h5 id="c2-2">2-2  修改个人信息</h5>
            <p>点击左侧“个人中心--修改个人信息”菜单允许用户修改自己的个人信息。但个人姓名、职位、所属小组等信息不可由用户自由修改。</p>
        <h5 id="c2-3">2-3  修改密码</h5>
            <p>点击左侧“个人中心--修改密码”允许用户修改密码。修改密码时必须提供原密码，且新密码需要输入两次以便确认。</p>
    </div>
        <br/>
    <%--第三部分--%>
    <div>
        <h4 id="c3">3  流程中心</h4>
        <h5 id="c3-1">3-1  发起请假流程</h5>
            <p>用户点击左侧菜单栏“流程中心--创建流程”，然后选择申请请假流程即可开始发起请假流程。在请假流程申请表单内需要填写请假开始和
            结束时间、请假类型、请假原因等信息。请假人不需要填写会自动填充。<br/>
            用户填写完成后点击提交申请即可。如果请假大于三天需要总监审批，否则经过经理审批。最后再经过HR审批后请假流程结束。</p>
        <h5 id="c3-2">3-2  发起报销流程</h5>
            <p>用户点击左侧菜单栏“流程中心--创建流程”，然后选择申请报销流程即可开始发起报销流程。在报销流程申请表单中需要填写报销金额、
                发生时间， 以及原因。报销人不需要填写会自动填充。<br/>
            用户填写信息后点击提交即可。在财务审批后会通过系统转账的方式发放报销款。如果系统转账失败可以通过现金支付的方式发放。</p>
        <h5 id="c3-3">3-3  发起调薪流程</h5>
            <p>用户点击左侧菜单栏“流程中心--创建流程”，然后选择申请调薪流程即可开始发起调薪流程。在调薪申请申请表单中需要填写调整金额、
                原因等信息，发起人不需要填会自动填充为自己。<br/>
                用户填写完表单提交即可。调整申请会先经过总监审批、人事审批，然后系统会记录薪资，最后经过老板审批。</p>
        <h5 id="c3-4">3-4  发起用印流程</h5>
            <p>用户点击左侧菜单栏“流程中心--创建流程”，然后选择申请用印流程即可开始发起用印流程。在用印流程申请表单中需要填写用印时间
                和用印原因，用印人不用填写会自动填充。<br/>
                用户填写完表单提交即可。申请需要依次经过总监和HR审批后结束。</p>
        <h5 id="c3-5">3-5  查询请假流程</h5>
            <p>用户点击左侧菜单栏“流程中心--流程记录”，然后选择“查询请假申请”来查看自己申请的请假流程。该页面同时提供流程图查看按钮。</p>
        <h5 id="c3-6">3-6  查新报销流程</h5>
            <p>用户点击左侧菜单栏“流程中心--流程记录”，然后选择“查询报销申请”来查看自己申请的报销流程。该页面同时提供流程图查看按钮。</p>
        <h5 id="c3-7">3-7  查询调薪流程</h5>
            <p>用户点击左侧菜单栏“流程中心--流程记录”，然后选择“查询调薪申请”来查看自己申请的调薪流程。该页面同时提供流程图查看按钮。</p>
        <h5 id="c3-8">3-8  查询用印流程</h5>
            <p>用户点击左侧菜单栏“流程中心--流程记录”，然后选择“查询用印申请”来查看自己申请的用印流程。该页面同时提供流程图查看按钮。</p>
        <h5 id="c3-9">3-9  查看流程图</h5>
            <p>用户可以点击查看流程图按钮查看流程图。流程图会显示流程的整体流程以及当前流程进行到了哪一环节。</p>
        <h5 id="c3-10">3-10  领取流程任务</h5>
            <p>具有任务审批权限的用户可以点击“流程中心--我的任务”选择代办任务查看自己可以办理的任务，因为任务权限是以组为单位的，
                ，同一个任务可以被多个人办理。所以用户点击领取， 将该任务领取为自己办理。</p>
        <h5 id="c3-11">3-11 审批流程任务</h5>
            <p>用户领取任务后，可以审批任务。点击“流程中心--我的任务”选择办理任务可以查看需要自己办理的任务。同时也可以查看任务的流程图。
            在办理任务页面可以看到该流程的表单信息和流程上游办理者的意见。同时办理者自己也可以提出意见并选择同意该任务或者驳回该任务。</p>
    </div>
        <br/>
    <%--第四部分--%>
    <div>
        <h4 id="c4">4  消息中心</h4>
        <h5 id="c4-1">4-1  发送消息</h5>
            <p>用户点击左侧菜单栏“消息中心--发送消息”可以发送消息，包括私人消息和小组消息。小组消息及同一个小组内的人都会收到该消息。<br/>
            同时，系统也可以调用消息服务来发送系统消息。</p>
        <h5 id="c4-2">4-2  发送公告</h5>
            <p>只有老板才可以发布公告。点击左侧菜单栏“消息中心--发送消息”在消息类型中选择“公告”即可（普通员工没有此选项）。</p>
        <h5 id="c4-3">4-3  查看消息列表</h5>
            <p>用户点击左侧菜单栏“消息中心--我的消息”可以查看消息列表。消息列表包括消息发送人、时间和标题，但不包括消息内容。</p>
        <h5 id="c4-4">4-4  查看消息详情</h5>
            <p>用户点击消息列表后的详情可以进入消息详情页面。该页面会详细的将消息信息全部打印出来。</p>
    </div>
        <br/>
    <%--第五部分--%>
    <div>
        <h4 id="c5">5  文件中心</h4>
        <h5 id="c5-1">5-1  上传文件</h5>
            <p>用户点击左侧菜单栏”文件中心--上传文件“可以上传文件，包括公司文件和小组文件。公司文件是全公司都可以查看，
                小组文件只有小组内的成员才可以查看。上传者和小组会自动填充。
            上传文件可以指定文件分类，如技术文档、产线日志等。</p>
        <h5 id="c5-2">5-2  下载文件</h5>
            <p>用户可以点击文档后面的下载按钮来下载文档，下载文档的前提是对该文档由查看权限。</p>
        <h5 id="c5-3">5-3  查找文件</h5>
            <p>提供两种方式来查找文件----通过关键字查找和通过分类查找。当然也可以通过关键字和分类组合查找。</p>
        <h5 id="c5-4">5-4  删除文件</h5>
            <p>文件的上传者可以删除文件。除此之外公司老板对所有文件都拥有权限。</p>
    </div>
        <br/>
    <%--第六部分--%>
    <div>
        <h4 id="c6">6  管理员板块</h4>
        <h5 id="c6-1">6-1  员工管理</h5>
            <p>HR拥有员工管理权限，点击左侧菜单栏“管理员区--员工管理”可以查看公司所有员工列表，同时可以进行如添加员工和删除员工等操作。</p>
        <h5 id="c6-2">6-2  小组管理</h5>
            <p>HR拥有小组管理权限。点击左侧菜单栏“管理员区--小组管理”可以查看公司所有用户组信息，但由于用户组和流程权限相关，
            HR没有删除用户组的权限。</p>
        <h5 id="c6-3">6-3  流程管理</h5>
            <p>老板拥有流程管理权限。点击左侧菜单栏“管理员区--流程管理”可以查看公司所以流程信息，同时可以选择中止流程和激活流程。<br/>
            中止流程意味着该流程不允许任何人发起。激活流程意味着该流程可以被人发起。</p>
        <h5 id="c6-4">6-4  公告管理</h5>
            <p>老板点击左侧菜单栏“管理员区--公告管理”可以对公司公告进行管理。</p>
        <h5 id="c6-5">6-5  文件管理</h5>
            <p>老板拥有对公司文件和全部小组文件的全部权限，如增删改查。</p>
    </div>
        <br/>
    <%--第七部分--%>
    <div>
        <h4 id="c7">7  初始数据</h4>
        <h5 id="c7-1">7-1  初始用户数据</h5>
        <div class="container">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>用户ID</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>所属用户组</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>employeeA</td>
                    <td>霍淇滨（员工）</td>
                    <td>123456</td>
                    <td>employeeGroup</td>
                </tr>
                <tr>
                    <td>employeeB</td>
                    <td>刘木子（员工）</td>
                    <td>123456</td>
                    <td>employeeGroup</td>
                </tr>
                <tr>
                    <td>hrA</td>
                    <td>蒋萍（人事）</td>
                    <td>123456</td>
                    <td>hrGroup</td>
                </tr>
                <tr>
                    <td>hrB</td>
                    <td>冯绍峰（人事）</td>
                    <td>123456</td>
                    <td>hrGroup</td>
                </tr>
                <tr>
                    <td>financeA</td>
                    <td>仇家辉（财务）</td>
                    <td>123456</td>
                    <td>financeGroup</td>
                </tr>
                <tr>
                    <td>financeB</td>
                    <td>魏星宇（财务）</td>
                    <td>123456</td>
                    <td>financeGroup</td>
                </tr>
                <tr>
                    <td>managerA</td>
                    <td>程浩森（经理）</td>
                    <td>123456</td>
                    <td>managerGroup</td>
                </tr>
                <tr>
                    <td>managerB</td>
                    <td>苏天昊（经理）</td>
                    <td>123456</td>
                    <td>managerGroup</td>
                </tr>
                <tr>
                    <td>directorA</td>
                    <td>赵鹏飞（总监）</td>
                    <td>123456</td>
                    <td>directorGroup</td>
                </tr>
                <tr>
                    <td>directorB</td>
                    <td>李俊奇（总监）</td>
                    <td>123456</td>
                    <td>directorGroup</td>
                </tr>
                <tr>
                    <td>bossA</td>
                    <td>马云（老板）</td>
                    <td>123456</td>
                    <td>bossGroup</td>
                </tr>
                </tbody>
            </table>
        </div>
        <br/>
        <h5 id="c7-2">7-2  初始用户组数据</h5>
        <div class="container">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>用户组ID</th>
                    <th>用户组名称</th>
                    <th>类型</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>employeeGroup</td>
                    <td>员工组</td>
                    <td>Staff</td>
                </tr>
                <tr>
                    <td>hrGroup</td>
                    <td>人力资源组</td>
                    <td>Staff</td>
                </tr>
                <tr>
                    <td>financeGroup</td>
                    <td>财务组</td>
                    <td>Staff</td>
                </tr>
                <tr>
                    <td>managerGroup</td>
                    <td>经理组</td>
                    <td>Staff</td>
                </tr>
                <tr>
                    <td>directorGroup</td>
                    <td>总监组</td>
                    <td>Manager</td>
                </tr>
                <tr>
                    <td>bossGroup</td>
                    <td>老板组</td>
                    <td>Manager</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
