<img src="https://z3.ax1x.com/2021/11/04/IVcxPJ.jpg" style="width:50%">

# 罐头工厂

本项目为2021年同济大学软件学院设计模式课程项目

小组成员包括：

| 小组成员 | 小组成员 |
| -------- | -------- |
| 卓正一   | 许王子路 |
| 汪明杰   | 孟繁霖   |
| 王立友   | 尚丙奇   |
| 梁乔     | 吴英豪   |
| 陈垲昕   | 香宁雨   |

## 项目简介

本项目选题为罐头加工厂。罐头加工厂励志为所有人提供最美味的罐头，全世界的人也慕名而来在加工厂里定制罐头，送给亲朋好友。罐头加工厂里有各种各样的罐头供大家随意挑选，糖渍苹果罐头、黄桃罐头、鲱鱼罐头、三文鱼罐头，每一种都是罐头加工厂的招牌。

想要进行订购的客户可以在订单创建系统中进行订单的创建，按需求订购自己喜欢的罐头。在网络上进行订单创建不仅方便快捷，个性化的定制更在满足客户的个性化需求的同时减少了浪费。急需罐头作为伴手礼或售卖的客户也不需要为紧迫的时间而感到担心，只需要告诉加工厂需要罐头的时间就可以如期拿到大家想要的罐头了。

当用户进行完订单创建后，数据会传输至订单中心，在订单中心中生成订单小票，供工厂进行账目的记录和处理，并通过唯一订单编号进行订单的标识。在工厂接到订单后，会先将订单发至库存管理部门，由库存管理部门在仓库中进行罐头的查找，如果当前罐头充足，则直接将罐头送至运输部门由运输部门进行罐头的运输。如果当前库存不能满足订单的需求，则会将当前需求发送给生产部门，通知他们生产罐头。

秉持着顾客就是上帝的原则，兢兢业业的生产部门会在订单的基础上沟通各个部门进行罐头的生产，保证送给每一位上帝的每一份罐头都是加工厂的员工们倾尽心血所做出的得意之作。生产部门首先会从采购部门获得所有需要的原材料，如果采购部门的原材料也告罄了，就进行采购单的填写，由采购部门向可靠的合作伙伴进行定量购买，让客户花的每一分钱都用在刀刃上。

在原材料成功购买后，就会被投入生产线进行生产。为实现口感和质量的双重保证，生产部门首先会对原材料进行筛选，筛选掉所有不符合标准的原材料，然后对原材料进行清洗、削皮等预处理，最后放入生产线进行加工。

好吃的内里已经加工好了，美观的外在也必不可少。生产完的罐头会被贴上精心设计的包装，在仓库中满心期待的等待送到客户手里的那一刻。运输部门会以最快的速度进行运输计划的定制以及承运商的委派，让已经等待许久的客户品尝到罐头的美味。

为提供优质的罐头，罐头加工厂不仅在流程上进行严格把控，同时也通过标准化人员管理进行规范化管理以及提高员工的幸福感。

当有新员工入职的时候，公司会对新员工的信息进行注册，并将其员工个人信息以及薪水信息计入公司报表中，让所有人员变动有迹可循。同时，经济部门下属的审计员会进行报表审核，保证员工的信息记录无误，并且按时记录并发放所有员工的工资。

在员工身体不适或因为其他事情需要请假的时候，公司会提供系统让员工进行请假的报备并进行请假流程的处理，实现人性化管理。

罐头加工厂有重大事情时，会通过公告机制将信息发给订阅公告栏的罐头工厂员工，加强公司内部信息的流动，实现信息的即时沟通。

美味的罐头等待您的购买！



## 系统架构图

<img src="https://z3.ax1x.com/2021/11/04/IVgiqK.png">





## 设计模式汇总

| 编号 | 设计模式名称                         | 文件体现                                                     | 功能体现                                                     | 备注说明                                                     |
| ---- | ------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
|      |                                      | 创建型设计模式                                               |                                                              |                                                              |
| 1    | 抽象工厂模式  Abstract Factory       | Manufacturing/ProductLine/test/ProductDepartment.java        | 总生产工厂创建生鲜和水果罐头生产线工厂                       | 23个经典设计模式之一                                         |
| 2    | 建造者模式  Builder                  | Marketing/Wrapping/Cover/WrappingDriver.java                 | 包装部门将不同的封面部分建造为包装封面                       | 23个经典设计模式之一                                         |
| 3    | 工厂方法模式  Factory  Method        | Manufacturing/ProductLine/test/ProductDepartment.java        | 生鲜和水果罐头生产线工厂提供具体罐头生产线                   | 23个经典设计模式之一                                         |
| 4    | 原型模式  Prototype                  | Manufacturing/CanEntity/ConcreteCan/PrototypeTest.java       | 大量重复罐头的克隆                                           | 23个经典设计模式之一                                         |
| 5    | 单例模式  Singleton                  | Presentation/Protocol/IOManager.java                         | 全局唯一的输入输出管理器                                     | 23个经典设计模式之一                                         |
| 6    | 转换器模式  Converter                | Marketing/Wrapping/Cover/WrappingDriver.java                 | 罐头实体到包装信息的转换与存储罐头到运输包裹的转换           | 《Core J2EE Patterns: Best Practices and Design Strategies》Author:Deepak  Alur, Dan Malks, John Crupi  ISBN:  9780131422469,0131422464 |
| 7    | 多例模式  Multiton                   | Manufacturing.Machine.CanTreatmentMachine/MultitonTest.java  | 罐头机器的数量限制                                           |                                                              |
|      |                                      | 结构型设计模式                                               |                                                              |                                                              |
| 8    | 适配器模式  Adapter                  | Manufacturing/ProductLine/Producer/Test/AdapterTest.java     | 罐头生产时可以应用已有精细或粗糙生产流程，运用适配器适配不通生产方式 | 23个经典设计模式之一                                         |
| 9    | 桥接模式  Bridge                     | Manufacturing/CanEntity/CanTest.java                         | 实现罐头的大小和包装材料                                     | 23个经典设计模式之一                                         |
| 10   | 组合模式  Composite                  | Ingredient/CompositeTest.java                                | 罐头内原材料的组合情况                                       | 23个经典设计模式之一                                         |
| 11   | 装饰器模式  Decorator                | Manufacturing.Ingredient.Procedure/DecoratorTest.java        | 员工上下班时需要分别穿上和脱下工作服                         | 23个经典设计模式之一                                         |
| 12   | 外观模式  Facade                     | Manufacturing/ProductLine/Pretreatment/Test/FacadeTest.java  | 罐头预处理需要筛选、消毒、削皮、等多个复杂工序，需要一个统一访问接口 | 23个经典设计模式之一                                         |
| 13   | 享元模式  Flyweight                  | Manufacturing/ProductLine/test/ProductDepartment.java        | 生产线工厂初次提供的每种生产线对象会保存下来避免频繁创建     | 23个经典设计模式之一                                         |
| 14   | 代理模式  Proxy                      | Managemen/Assets/Announcement/BlackBoardTest.java            | 公告管理员代替广播员发送公告                                 | 23个经典设计模式之一                                         |
| 15   | 数据访问对象模式  DAO                | Management/HumanResources/test/FinancialDepartmentTest.java  | 人员薪水持久化存储的访存与逻辑代码解耦                       | M. Birbeck, Professional XML,  Beijing: Machine Press, 2002, ch. 1, pp. 14-16 |
| 16   | 脏标记模式  DirtyFlag                | Management/HumanResources/Staff/Auditor.java                 | 审计薪水报告时对脏标记进行检查判断当前报告是否已经被审核过   | 《Game Programming  Patterns》 Author：Robert  Nystrom ISBN: 978-0-9905829-0-8(Page 291) |
|      |                                      | 行为型设计模式                                               |                                                              |                                                              |
| 17   | 责任链模式  Chain of  Responsibility | Management/HumanResources/test/ChainOfResponsibilityTest.java | 员工请假时请假请求按照等级传递给上级别领导                   | 23个经典设计模式之一                                         |
| 18   | 命令模式  Command                    | Management/HumanResources/test.java                          | 经济管理部门下达命令，要求部门下的一名审计员审计薪水报告     | 23个经典设计模式之一                                         |
| 19   | 解释器模式  Interpreter              | Presentation/IOSysetm/ControlExpression.java                 |                                                              | 23个经典设计模式之一                                         |
| 20   | 迭代器模式  Iterator                 | Wrapping/IteratorPatternTest.java                            | 按需扫描订单中心内的所有订单                                 | 23个经典设计模式之一                                         |
| 21   | 中介者模式  Mediator                 | Mediator.DepartmentMediator.java                             | 各部门之间处理订单逻辑，传递订单信息的中介部门               | 23个经典设计模式之一                                         |
| 22   | 备忘录模式  Memento                  | Management/HumanResource/FinancialSystem/ReportMemento.java  | 审核薪资报表时生成备忘录以便公司查看或恢复历史版本           | 23个经典设计模式之一                                         |
| 23   | 观察者模式  Observer                 | Manufacturing/ProductLine/Upstream/ConcreteUpstreamFactory.java | 上游工厂通过观察者模式对工厂购买计划进行观察并进行产品的销售 | 23个经典设计模式之一                                         |
| 24   | 状态模式  State                      | Marketing/OrderEntity/OrderState.java                        | 管理订单的几种状态                                           | 23个经典设计模式之一                                         |
| 25   | 策略模式  Strategy                   | Marketing/Promotion/SaleTest.java                            | 下单时使用不同优惠券降低价格                                 | 23个经典设计模式之一                                         |
| 26   | 模板方法模式  Template               | Manufacturing/ProductLine/test/ProductDepartment.java        | 工厂生产活动按照一定的模板进行                               | 23个经典设计模式之一                                         |
| 27   | 访问者模式  Visitor                  | Management/QuantityTesting/VisitorTest.java                  | CEO和经理了解保洁员和保安的工作质量                          | 23个经典设计模式之一                                         |
| 28   | 黑板模式  Blackboard                 | Management/Assets/Announcement/BlackBoardTest.java           | 工厂中公告的发布                                             |                                                              |
| 29   | 委派模式  Delegate                   | Management/HumanResources/test/TransportDepartmentTest.java  | 经理安排人员采购和运输                                       | 《J2EE Design  Patterns: Patterns in the Real World》Author:William  Crawford, Jonathan Kaplan |
| 30   | 过滤器模式  Filter                   | Manufacturing/ProductLine/Pretreatment/Test/FacadeTest.java  | 生产原料预处理过程中需要过滤不合格原料                       | 《Patterns in Java:  A Catalog of Reusable Design Patterns Illustrated with UML》Author：Mark Grand |



## 参考文献

[1] Deepak Alur, Dan Malks, John Crupi . Core J2EE Patterns: Best Practices and Design Strategies. Prentice Hall PTR, 2003. 395-397.

[2] M. Birbeck. Professional XML. Beijing: Machine Press, 2002. 14-16

[3] Robert Nystrom.Game Programming Patterns[M]ISBN: 978-0-9905829-0-8,2004,291

[4] William Crawford, Jonathan Kaplan. J2EE Design Patterns - Patterns in the Real World.[M]DBLP:William Crawford,2003.37:50

[5] Grand M . Patterns in Java: A Catalog of Reusable Design Patterns Illustrated with UML, 2nd Edition, Volume 1[J]. computer bookshops, 2002, 21(9):153-162.