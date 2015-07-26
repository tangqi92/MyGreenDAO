MyGreenDAO
==========
 MyGreenDAO 是我在学习使用 ORM 框架 greenDAO 时精简出来的，旨在帮助大家能方便的在 Android Studio 上使用并扩展 [greenDAO](http://greendao-orm.com/)

# Usage

### Stept 1
欢迎 **Fork** 与 **Star**，随后你可以选择「Clone」or 「Download」

### Stept 2

你可以通过如下图所示「Import an Android code sample」的方式导入工程  

![](http://7xikfc.com1.z0.glb.clouddn.com/Screen%20Shot%202015-07-26%20at%202.15.47%20PM_meitu_1.png)

 你也可以通过如下图所示「File -> New -> Import Project」的方式导入  
 
![](http://7xikfc.com1.z0.glb.clouddn.com/Screen%20Shot%202015-07-26%20at%202.15.07%20PM.png)

### Stept 3

如一切正常（compileSdkVersion 与 buildToolsVersion 等需根据自己实际情况更改），你只需要修改 [ExampleDaoGenerator](https://github.com/tangqi92/MyGreenDAO/blob/master/daoexamplegenerator/src/main/java/me/itangqi/ExampleDaoGenerator.java) 类中如下这条语句，「..」替换为你实际的存放目录即可   

```java
new DaoGenerator().generateAll(schema, "../MyGreenDAO/app/src/main/java-gen");
```  

# Documentation

[ORM 框架之 greenDAO 使用心得](http://itangqi.me/android/using-greendao-experience/)  

# Thanks to

[greenDAO](https://github.com/greenrobot/greenDAO)  

# Contact Me

- Weibo：[@汤奇V](http://weibo.com/qiktang)
- Gmail：[imtangqi#gmail.com](mailto:imtangqi@gmail.com "欢迎与我联系")
- Blog: [http://itangqi.me/](http://itangqi.me/)  

# License


    Copyright (C) 2015 Qi Tang

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
