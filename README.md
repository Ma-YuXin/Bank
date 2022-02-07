
    用户需要登录系统，并进行注册与登录，进入系统后可以选择完善自己的个人信息。然后进行添加银行卡，并完善银行卡的相关信息。
  之后便可以进行存取款，贷款转账。在进行对应操作的同时，系统将会自动生成历史账单。
  主要功能：登录注册，完善个人信息，增删银行卡，存取款，转账贷款，异常处理，以及相应的错误提示增加系统的稳定性。

 **系统框架** 
根据要求，设计网站前端页面的内容与跳转，包含登录注册、用户管理、银行卡管理、存取款管理、贷款管理、业务提醒、历史账单查询共计七个模块

开发工具：Intellij IDEA

后台框架:  Spring Boot+Mybaits+MySQL

模板引擎：Thymeleaf

依赖包管理: Maven




使用流程图！

数据库建表文件为create.sql在idea中直接运行即可。
insertData文件为随机生成的数据文件，idea中运行后可插入数据。
然后maven导入相关的包即可；

浏览器访问地址为 https://localhost:8080

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204727_f5f0da01_8491872.png "屏幕截图.png")


数据库关系图以及相应的属性

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/203904_b3529dcd_8491872.png "屏幕截图.png")


 主页

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204121_0090cc84_8491872.png "屏幕截图.png")

登陆界面

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204126_8aaef7e6_8491872.png "屏幕截图.png")

注册界面 

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204157_c63ec60c_8491872.png "屏幕截图.png")

单项修改个人信息界面

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204200_5860ac96_8491872.png "屏幕截图.png")

同时修改多项个人信息界面

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204204_79100e25_8491872.png "屏幕截图.png")

历史账单界面

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204210_3021ac07_8491872.png "屏幕截图.png")

转账界面

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204213_7f346342_8491872.png "屏幕截图.png")

贷款界面  

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204225_da7506fa_8491872.png "屏幕截图.png")

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204218_422190c1_8491872.png "屏幕截图.png")

存款界面

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204245_59e8778d_8491872.png "屏幕截图.png")

八、测试和运行

介绍系统的测试情况，可提供几个测试用例。
可选：生成大数据量的仿真数据，进行性能测试的情况。
 
登陆
登陆一切正常：用户名，密码一致即可否则报错

 ![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204354_c4ddbec9_8491872.png "屏幕截图.png")

修改密码
成功后会有提示，如果两次不一致则重新输入 

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204357_e4a8c3e6_8491872.png "屏幕截图.png")

删除银行卡

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204402_6eb0741b_8491872.png "屏幕截图.png")
 
取款

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204406_8054ad81_8491872.png "屏幕截图.png")

存款

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204410_b604e7b7_8491872.png "屏幕截图.png")

查看历史账单

![输入图片说明](https://images.gitee.com/uploads/images/2021/0927/204416_ceb6e419_8491872.png "屏幕截图.png")


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
