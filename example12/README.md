# DataBinding
https://developer.android.google.cn/topic/libraries/data-binding

1.在项目gradle配置中，启动dataBinding
添加整合了viewModel liveData的依赖lifecycle-extensions

**官方推荐一个activity对应绑定一个ViewModel**

**基本实现，基于mainActivity**
2.创建实体类
3.创建自定义viewModel类
4.声明页面数据绑定/生命周期绑定的MutableLiveData类型数据
5.创建修改方法，在子线程中修改数据