# OASystem
3.1  系统预设数据
办公自动化系统预设了一些用户信息和用户组信息，方便进行系统测试和验证。
系统中预设了6个用户组，分别是员工组、人力资源组、财务组、经理组、总监组和老板组。系统预设的用户组信息如表3.1所示。
表3.1  系统预设用户组信息表
用户组ID	用户组名称	类型
employeeGroup	员工组	Staff
hrGroup	人力资源组	Staff
financeGroup	财务组	Staff
managerGroup	经理组	Staff
directorGroup	总监组	Manager
bossGroup	老板组	Manager
系统对老板组预设了一条职员信息，其他各组分别预设两条职员信息。系统预设用户信息表如表3.2所示。
表3.2  系统预设用户信息表
用户ID	用户名	密码	所属用户组
employeeA	霍淇滨（员工）	123456	employeeGroup
employeeB	刘木子（员工）	123456	employeeGroup
hrA	蒋萍（人事）	123456	hrGroup
hrB	冯绍峰（人事）	123456	hrGroup
financeA	仇家辉（财务）	123456	financeGroup
financeB	魏星宇（财务）	123456	financeGroup
managerA	程浩森（经理）	123456	managerGroup
managerB	苏天昊（经理）	123456	managerGroup
directorA	赵鹏飞（总监）	123456	directorGroup
directorB	李俊奇（总监）	123456	directorGroup
bossA	马云（老板）	123456	bossGroup
3.2  个人模块
3.2.1  登录/登出
（1）登录
在登录页面提供用户名和密码登录系统。此系统不支持用户自己注册，一些添加用户的操作由人事在管理员模块进行。
（2）登出
系统主页面顶端导航栏“退出”按钮提供登出系统功能，登出系统会删除服务器session信息，并回到登陆页面。
3.2.2  查看个人信息
用户成功登录系统后会直接跳转到用户的个人信息界面，用户也可以手动选择左侧菜单栏【个人中心 > 查看个人信息】进入用户信息界面。用户在该界面可以查看自己所属小组、自己的职位、邮箱、年龄等个人信息。
3.2.3  修改个人信息
点击左侧菜单栏【个人中心 > 修改个人信息】选项允许用户修改自己的个人信息。但个人姓名、职位、所属小组等信息不可由用户自由修改。此外，用户个人信息页面也提供“更新信息”按钮进入修改页面。
3.2.4  修改密码
点击左侧菜单栏【个人中心 > 修改密码】允许用户修改密码。修改密码时必须提供原密码，且新密码需要输入两次以便确认。此外，用户个人信息页面也提供“修改密码”按钮进入修改页面。
3.2.5  查看系统帮助
系统主页面顶端导航栏“帮助”按钮提供系统帮助手册，方便用户随时查看如何使用系统。
3.3  流程模块
3.3.1  申请流程
（1）申请请假流程
用户点击左侧菜单栏【流程中心 > 创建流程 > 申请请假流程】即可申请请假流程。在请假流程申请表单内需要填写请假开始和结束时间、请假天数、请假类型、请假原因等信息。请假人信息不需要填写，系统会根据当前登录用户自动填充。
用户填写完成后点击提交申请即可。如果请假大于三天需要总监审批，否则经过经理审批。最后再经过HR审批后请假流程结束。
（2）申请报销流程
用户点击左侧菜单栏【流程中心 > 创建流程 > 申请报销流程】即可申请报销流程。在报销流程申请表单中需要填写报销金额、发生时间以及原因。报销人信息不需要填写，系统会根据当前登录用户自动填充。
用户填写信息后点击提交即可。在财务审批后会通过系统转账的方式发放报销款。如果系统转账失败可以通过现金支付的方式发放。
（3）申请调薪流程
用户点击左侧菜单栏【流程中心 > 创建流程 > 申请调薪流程】即可申请调薪流程。在调薪申请申请表单中需要填写调整金额、 原因等信息。发起人信息不需要填写系统会根据登录用户自动填充。
用户填写完表单提交即可。调整申请会先经过总监审批、人事审批，然后系统会记录薪资，最后经过老板审批。
（4）申请用印流程
用户点击左侧菜单栏【流程中心 > 创建流程 > 申请用印流程】即可申请用印流程。在用印流程申请表单中需要填写用印时间 和用印原因。用印人不用填写系统会根据当前登录用户自动填充。
用户填写完表单提交即可。申请需要依次经过总监和HR审批后结束。
3.3.2  查询流程申请信息
用户点击左侧菜单栏【流程中心 > 流程记录】进入流程记录页面，然后可分别选择“请假流程记录”、“报销流程记录”、“调薪流程记录”或“用印流程记录”来分别查看自己各个分类下的流程申请信息。
3.3.3  查看流程图
在流程申请信息页面提供有“查看流程图”功能，点击该按钮可以查看流程图。流程图中会用红框标注该留策划你进行到了哪一环节。
3.3.4  领取流程任务
具有任务审批权限的用户可以点击【流程中心 > 我的任务 > 待办任务】查看自己可以办理的任务。因为任务权限是以组为单位的，同一个任务可以被同一组的多个人办理。所以用户点击领取，将该任务领取为自己办理。然后才能办理任务。
3.3.5  审批流程任务
用户领取任务后需要审批任务。点击【流程中心 > 我的任务 > 待办理的任务】查看需要自己办理的任务,同时也可以查看任务的流程图。在办理任务页面可以看到该流程的表单信息和流程上游办理者的意见。同时办理者自己也可以提出意见并选择同意或者驳回该任务。
3.4  消息模块
3.4.1  发送消息/公告
点击左侧菜单栏【消息中心 > 发送消息】可以发送消息，包括个人消息、小组消息和公告。个人消息需要执行某人为接收方，小组消息需要指定一个小组为接收方，公告只能由老板发布，且不需要指定接收方。同时，系统也可以调用消息服务来发送系统消息。
3.4.2  查看消息列表
点击左侧菜单栏【消息中心 > 我的消息】可以查看消息列表。消息列表包括消息发送人、时间和标题，但不包括消息内容。
3.4.3  查看消息详情
消息列表页面中每条消息后提供“详情”按钮查看该消息内容。消息详情页面会详细显示消息的全部信息。
3.4.4  查看公告信息
点击左侧【消息中心 > 公告】可以进入公告页面。公告页面提供老板发布的所有公告信息，所有员工都可查看。
3.5  文件模块
3.5.1  上传文件
点击左侧菜单栏【文件中心 > 上传文件】进入上传文件页面。可以上传公司文件和小组文件。公司文件全公司都可以查看而小组文件只有小组内的成员才可以查看。上传文件需要指定文件分类，如技术文档、产线日志等。
3.5.2  查找文件
点击左侧【文件中心 > 文件列表】进入文件页面。文件页面提供两种方式来查找文件：关键字查找和分类查找。当然也可以通过关键字和分类组合查找。
3.5.3  下载文件
文件列表页面中每条文件信息后提供“下载”按钮，用户可以点击按钮下载文件。系统没有对下载文件做单独的权限验证，用户对文件拥有查看权限也即拥有下载权限。
3.5.4  删除文件
文件列表页面中每条文件信息后提供“删除”按钮，用户可以点击按钮删除文件。文件的上传者可以删除文件。除此之外公司老板对所有文件都拥有权限。
3.6  管理员模块
3.6.1  员工管理
人事组拥有员工管理权限，点击左侧菜单栏【管理员区 > 员工管理】可以查看公司所有员工列表，同时提供添加员工、删除员工、充值员工密码等功能。
3.6.2  用户组管理
人事拥有用户组查看权限。点击左侧菜单栏【管理员区 > 小组管理】可以查看公司所有用户组信息，但由于用户组和流程权限相关，HR没有删除用户组的权限。
3.6.3  流程管理
老板组拥有流程管理权限。点击左侧菜单栏【管理员区 > 流程管理】可以查看公司所有流程信息，同时可以选择中止流程和激活流程。
中止流程意味着该流程不允许被任何人发起。激活流程意味着该流程可以被人发起。
3.6.4  公告管理
老板组拥有公告管理权限。点击左侧菜单栏【管理员区 > 公告管理】可以查看目前所有的公告，且可以删除公告。
3.6.5  文件管理
老板组拥有对公司文件和全部小组文件的全部权限。点击左侧菜单栏【管理员区 > 文件管理】，可以为老板组提供全部文件管理操作。
