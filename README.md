MyGreenDAO
==========

<p>
<img src="http://7xikfc.com1.z0.glb.clouddn.com/gr_logo.png" width="100px" height="100px" align="left" hspace="15px" />
MyGreenDAO 是我在学习使用 ORM 框架 greenDAO 时在官方提供的 Example Project 上精简出来的 Demo，并添加了详细的注释说明，旨在帮助大家能快速了解、上手使用并扩展 greenDAO。我会持续跟新 MyGreenDAO，不断优化与添加新的功能，欢迎大家 Fork 与 Star 。                                      
</p>                                                                        

**Demo is still in development so more features will be added soon**

  - [Usage](#usage)
  - [Download](#download)
  - [Documentation](#documentation)
  - [Thanks to](#thanks-to)
  - [Contact Me](#contact-me)
  - [License](#license)

# Usage

### Dependency - 依赖
  - Java Development Kit (JDK) 8 +
  - com.android.tools.build:gradle:1.2.3
  - Android SDK
    - Android SDK Build-tools 22.0.1


### Build - 构建

    git clone https://github.com/tangqi92/MyGreenDAO.git

用最新的IntelliJ IDE导入工程（Import Project），然后等待IDE下载gradle和依赖包即可

This project uses the Gradle build system. To build this project, use the "gradlew build" command or use "Import Project" in Android Studio.

是时候和 Eclipse 说拜拜了，赶紧拥抱 [Android Studio](https://developer.android.com/sdk/index.html) 吧！！！

### Modify - 修改

如一切正常（compileSdkVersion 与 buildToolsVersion 等需根据自己实际情况更改），你只需要修改 [ExampleDaoGenerator](https://github.com/tangqi92/MyGreenDAO/blob/master/daoexamplegenerator/src/main/java/me/itangqi/ExampleDaoGenerator.java) 类中如下这条语句，「..」替换为你实际的存放目录即可   

```java
new DaoGenerator().generateAll(schema, "../MyGreenDAO/app/src/main/java-gen");
```  

# Download
[MyGreenDAO-1.0.0.apk](https://s3.amazonaws.com/github-cloud/releases/39712109/aa4b3f94-34bb-11e5-9322-dcc06b0ef936.apk?response-content-disposition=attachment%3B%20filename%3DMyGreenDAO-1.0.0.apk&response-content-type=application/vnd.android.package-archive&AWSAccessKeyId=AKIAISTNZFOVBIJMK3TQ&Expires=1438013219&Signature=9yBAk7Pc5vT3Wxr0bxZlv2ikkq0%3D)

# Documentation

[ORM 框架之 greenDAO 使用心得](http://itangqi.me/android/using-greendao-experience/)  

# Thanks to

[greenDAO](https://github.com/greenrobot/greenDAO)  

# Contact Me

- Weibo：[@汤奇V](http://weibo.com/qiktang)
- Gmail：[imtangqi#gmail.com](mailto:imtangqi@gmail.com "欢迎与我联系")
- Blog: [http://itangqi.me](http://itangqi.me)  

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
