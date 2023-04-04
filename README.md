# 贪吃蛇游戏
代码的核心用一句话概括，即为定时区对逻辑区与绘图区的调用

### 一、定时区
位于GameFrame的timertask与time。在创建对象
timertask时将逻辑区与绘图区的执行内容写入run函数，再创建timer对象用于定时
执行timertask的任务，在gameframe的构造函数中使用
timer.scheduleAtFixedRate(task,0,200)。使timer在0毫秒
后，每200毫秒执行一次task中的任务。
### 二、逻辑区
位于Object包的各个类中，task首先调用snake的move函数使蛇移动
然后是敌人移动（enemy move），攻击（enemy attack），检测蛇是否
撞到墙壁或者自己。其余的函数不在这里一一列举。
### 三、绘画区
位于Gameframe的paint中。task通过调用repaint函数
调用paint函数。在paint函数中，image为画布，g_image（g）为画笔
g的使用方法在学习通5.1中有介绍，在这里列出我使用的函数
#### 1. clearRect(x,y,w,h)
清除位于（x，y），宽为w，高为h的长方形中的内容
#### 2. setColor(Color)
设置画笔的颜色
#### 3. fillRect(x,y,w,h)
用画笔的颜色填充位于（x，y），宽为w，高为h的长方形
#### 4.drawLine(x1,y1,x2,y2)
用画笔的颜色在（x1，y1）与（x2，y2）之间画线

#### 偏移值（gameframe中的x，y）
在窗口的形状发生变化后，产生相应的偏移值
![偏移值](Snake%2FPicture%2Fx.png)



