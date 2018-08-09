# cv_filter_android
简历筛选android端:https://github.com/panmengze1991/cv_filter_android 

简历筛选服务端：https://github.com/lijunfeng722/CVFilter


## 接口描述
>服务器地址：待更新

描述 | 接口 | 请求类型 | 参数 | 返回结果（成功） | 返回结果（失败）
-|-|-|-|-|-
获取配置参数 | getProperty | get | 无 | {"filterOptions":{"age":22,"durationBachelor":"3年","durationNormal":"5年","gender":"男","isPublic":"否","leaveRate":"1年1次"},"msg":"请求成功","result":1} | {"msg":"请求失败","result":0}
提交配置参数 | postProperty | post | {"age":22,"durationBachelor":"3年","durationNormal":"5年","gender":"男","isPublic":"否","leaveRate":"1年1次"} | {"msg":"请求成功","personList":[{"age":22,"avatar":2130837590,"description":"很强的人","duration":"1年","duty":"软件工程师","gender":"男","graduateFrom":"中国科学技术大学","jobExp":"一家企业","name":"李狗蛋","projectExp":"非常多的项目","skill":"JAVA C++ Python "},{"age":22,"avatar":2130837590,"description":"很强的人","duration":"1年","duty":"软件工程师","gender":"男","graduateFrom":"中国科学技术大学","jobExp":"一家企业","name":"李狗蛋","projectExp":"非常多的项目","skill":"JAVA C++ Python "}],"result":1} | {"msg":"请求失败","result":0}
