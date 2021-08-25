

# Android DataBinding

[DataBinding 文档](https://developer.android.google.cn/topic/libraries/data-binding/)

[Demo 代码 github传送门](https://github.com/itrenjunhua/AndroidDataBinding/) 

简书：[ViewModel、LiveData 使用](https://www.jianshu.com/p/83cfc46cdebd)

CSDN：[ViewModel、LiveData 使用](https://blog.csdn.net/ITRenj/article/details/96933135)

简书：[ViewModel+LiveData+DataBinding使用](https://www.jianshu.com/p/699cf6117b53)

CSDN：[ViewModel+LiveData+DataBinding使用](https://blog.csdn.net/ITRenj/article/details/97787655)

## 简单使用数据绑定
### 1、添加 Android DataBinding 支持
Android studio 需要在1.3以上，在module级别的gradle中添加大DataBinding支持

    android {

        dataBinding {
            enabled = true
        }
    }

### 2、在 xml 布局文件中绑定数据
使用 DataBinding 的xml布局文件和普通的布局文件唯一的区别就是根节点变为 `layout` ；然后增加了 `data` 节点，存放绑定的数据；其余的布局和普通的一样

    <?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">

        <!-- 定义绑定的数据 -->
        <data>

        </data>

        <!-- 显示的布局 -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

        </LinearLayout>

    </layout>

### 3、定义数据绑定对象

    public class UserBean {
        private String username;
        private String address;

        public UserBean(String username) {
            this.username = username;
        }

        public UserBean(String username, String address) {
            this.username = username;
            this.address = address;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

### 4、在 XML 文件中定义数据

     <data>
            <variable
                name="user"
                type="com.renj.databinding.entity.UserBean" />
        </data>

### 5、Activity 类中修改
> ① 修改 `setContentView()` 方法为
`ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);`  
> ② 设置 XML 中需要的变量值 `binding.setUser(new UserBean("张三", "浙江省杭州市"));`  

* **注意：类名 `ActivityMainBinding` 是根据布局文件名 "activity_main" 自动生成的，规则为：第一个字母大写，下划线去掉，下划线之后的第一个字母大写(驼峰式命名方式)，然后加上'Binding'，组成Binding类的类名。当然也可以自定义，在后文中有说明【自定义 [Binding类名]】**

## [事件绑定](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/java/com/renj/databinding/activity/EventBindingActivity.java)
> 事件绑定

① 定义事件处理对象

    public class Presenter {
            public void click(View view) {
                int viewId = view.getId();
                if (viewId == R.id.bt_click1) {
                    UIUtil.showToast("通过id区分事件1");
                } else if (viewId == R.id.bt_click2) {
                    UIUtil.showToast("通过id区分事件2");
                }
            }

            public void clickMethod1(View view) {
                UIUtil.showToast("调用单个方法1");
            }

            public void clickMethod2(View view) {
                UIUtil.showToast("调用单个方法2");
            }

            public void lambdaMethod(View view) {
                UIUtil.showToast("Lambda表达式方式");
            }

            public void paramsMethod(View view, Context context, String params) {
                UIUtil.showToast(params);
            }
        }
② 在布局文件中定义并调用

    <layout xmlns:android="http://schemas.android.com/apk/res/android">
        <data>
            <variable
                name="presenter"
                type="com.renj.databinding.activity.EventBindingActivity.Presenter" />
        </data>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:padding="@dimen/default_padding">

            <Button
                android:id="@+id/bt_click1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:onClick="@{presenter.click}"
                android:text="通过id区分事件1"
                android:textColor="@color/color_main_text"
                android:textSize="@dimen/default_text_size" />

            <Button
                android:id="@+id/bt_click2"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:onClick="@{presenter::click}"
                android:text="通过id区分事件2"
                android:textColor="@color/color_main_text"
                android:textSize="@dimen/default_text_size" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:onClick="@{presenter.clickMethod1}"
                android:text="调用单个方法1"
                android:textColor="@color/color_main_text"
                android:textSize="@dimen/default_text_size" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:onClick="@{presenter::clickMethod2}"
                android:text="调用单个方法2"
                android:textColor="@color/color_main_text"
                android:textSize="@dimen/default_text_size" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:onClick="@{(view) -> presenter.lambdaMethod(view)}"
                android:text="Lambda表达式方式"
                android:textAllCaps="false"
                android:textColor="@color/color_main_text"
                android:textSize="@dimen/default_text_size" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:onClick='@{(view) -> presenter.paramsMethod(view,context,"params")}'
                android:text="传递参数"
                android:textColor="@color/color_main_text"
                android:textSize="@dimen/default_text_size" />

        </LinearLayout>

    </layout>

③ 设置XML需要的对象

    binding.setPresenter(new Presenter());

> 事件监听

与事件绑定类似，**不同的是参数要和监听的回调参数完全一致**。

① 定义事件处理对象

    public class Presenter {
            public void onEditTextChange(Editable editable) {
                        btContent.set("输入内容：" + editable.toString());
                    }
        }
② 在布局文件中定义并调用

    <layout xmlns:android="http://schemas.android.com/apk/res/android">
        <data>
            <variable
                name="btContent"
                type="android.databinding.ObservableField&lt;String>" />
        </data>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:padding="@dimen/default_padding">

            <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:afterTextChanged="@{presenter.onEditTextChange}"
                android:hint="绑定 afterTextChanged 事件"
                android:textColor="@color/color_main_text"
                android:textColorHint="@color/color_main_hint"
                android:textSize="@dimen/default_text_size" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="@{btContent}"
                android:textColor="@color/color_main_text"
                android:textSize="@dimen/default_text_size" />

        </LinearLayout>

    </layout>

③ 设置XML需要的对象

    binding.setPresenter(new Presenter());

## 在 data 标签中 [导入类、定义别名](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/res/layout/activity_import.xml)

    <data>
        <import type="com.renj.databinding.entity.OneWayBean" />
        <import
            alias="User"
            type="com.renj.databinding.entity.UserBean" />
        <variable
            name="user"
            type="User" />
        <variable
            name="oneWayBean"
            type="OneWayBean"/>
    </data>

* **注意别名和定义的变量名不能相同**

## 自定义 [Binding类名](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/res/layout/activity_bind_class_name.xml)

     <!--自定义包名和类名-->
    <!--<data class="com.ren.databinding.custom.CustomClassNameBinding">-->
    <data class=".CustomClassNameBinding">

        <variable
            name="user"
            type="com.renj.databinding.entity.UserBean" />
    </data>

## 表达式
> 支持的运算符：

* 数学运算符： + - / * %
* 字符串拼接： +
* 逻辑运算符： && ||
* 二进制： & | ^
* 一元运算符： +
* 位运算符： >> >>> <<
* 比较： == > < >= <=
* instanceof
* ()
* 数据类型： character, String, numeric, null
* 类型转换（ClassCast）
* 方法回调（Method calls）
* 数据属性
* 数组：[]
* 三元操作符：? :

> 一些在java中常用而DataBinding xml中不支持的：

* this
* super
* new
* 泛型

> **“??”操作符：**

    android:text="@{user.displayName ?? user.lastName}"
它等于：

    android:text="@{user.displayName != null ? user.displayName : user.lastName}"

## 双向绑定

我们使用 `@{}` 时表示单向绑定，而使用 [双向绑定](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/res/layout/activity_data_two_way.xml) 也很简单，使用 `@={}` 即可。
**前提：**
> 我们的数据对象需要继承 `android.databinding.BaseObservable` 类，并且做如下处理：
使用 `@Bindable` 注解标记 `getXxx` 方法，在 `setXxx` 方法中通知发生改变(notifyPropertyChanged)

    public class TwoWayBean extends BaseObservable {
        private String fastName;
        private String lastName;

        public TwoWayBean() {
        }

        public TwoWayBean(String fastName, String lastName) {
            this.fastName = fastName;
            this.lastName = lastName;
        }

        @Bindable
        public String getFastName() {
            return fastName;
        }

        public void setFastName(String fastName) {
            this.fastName = fastName;
            notifyPropertyChanged(BR.fastName);
        }

        @Bindable
        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
            notifyPropertyChanged(BR.lastName);
        }
    }


> 当然，当我们不想需要整个对象的字段都进行双向绑定，可以使用DataBinding框架提供的其他相关对象：

* ObservableBoolean
* ObservableByte
* ObservableChar
* ObservableShort
* ObservableInt
* ObservableLong
* ObservableFloat
* ObservableDouble
* ObservableParcelable
* ObservableField<T>

---
例：

    public final ObservableMap<String,String> observableMap = new ObservableArrayMap<>();
    observableMap.put("firstName","Zhang");
    observableMap.put("lastName","San");

#### 目前Android支持的双向绑定控件(其他的我们也可以自定义)：
![android_two_way.png](https://upload-images.jianshu.io/upload_images/18657923-dd175ecd44da5bee.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


## [动态 ViewDataBinding](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/java/com/renj/databinding/activity/ListBindingActivity.java)
[有时候我们可能不知道Binding类的名称](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/java/com/renj/databinding/activity/ListBindingActivity.java) ，比如 `RecyclerView.Adapter` 中item布局可能有很多，并不会对应特定的Binding类，但是仍然需要通过 `onBindViewHolder(VH, int)` 去绑定数据，下面的列子是，所有的子布局都有一个"item"变量，通过ViewDataBinding基类去完成绑定：

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ViewDataBinding viewDataBinding = holder.getViewDataBinding();
        viewDataBinding.setVariable(BR.itemValue, dataList.get(position));
        viewDataBinding.executePendingBindings();
    }

* 当一个变量被绑定或者绑定的对象发生变化是，DataBinding会让这些改变排队去在下一帧刷新之前改变，有些时候binding效果必须立刻执行，这时候可以使用 `executePendingBindings()`。


## Include 使用
[DataBinding 和 include 一起使用时](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/java/com/renj/databinding/activity/IncludeBindingActivity.java) ，和普通的 include 使用并无太大不同，只需要把所需的绑定数据传给 include 布局即可。

    <?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:bind="http://schemas.android.com/apk/res-auto">

        <data>

            <variable
                name="user"
                type="com.renj.databinding.entity.UserBean" />
        </data>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <include
                layout="@layout/include_layout"
                bind:user="@{user}" />

        </LinearLayout>

    </layout>

> include 布局 XML 文件

    <?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:android="http://schemas.android.com/apk/res/android">

        <data>

            <variable
                name="user"
                type="com.renj.databinding.entity.UserBean" />
        </data>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

        </LinearLayout>

    </layout>

**注意：include 布局 XML 文件的根节点不能是 `merge` 标签**

## ViewStub 使用
[DataBinding在ViewStub中使用](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/java/com/renj/databinding/activity/ViewStubBindingActivity.java) ，我们需要创建一个监听器，当ViewStub的布局完成时，将绑定数据设置进去。

> 包含 ViewStub 控件的布局

    <?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:android="http://schemas.android.com/apk/res/android">

        <data>

        </data>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <ViewStub
                android:id="@+id/view_stub"
                android:layout="@layout/view_stub_layout"
                android:layout_width="match_parent"
                android:layout_height="match_parent" />

        </LinearLayout>

    </layout>


> view_stub_layout 布局

    <?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:android="http://schemas.android.com/apk/res/android">

        <data>

            <variable
                name="user"
                type="com.renj.databinding.entity.UserBean" />
        </data>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

        </LinearLayout>

    </layout>

> 在代码中使用

    // 设置监听，控件显示完成之后绑定数据
    binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
        @Override
        public void onInflate(ViewStub stub, View inflated) {
            // ViewStub 使用 DataBindingUtil 的方式
            ViewStubLayoutBinding viewStubLayoutBinding = DataBindingUtil.bind(inflated);
            viewStubLayoutBinding.setUser(new UserBean("李四", "湖南省长沙市"));
        }
    });

    // 显示 ViewStub 控件
    binding.viewStub.getViewStub().inflate();

## 属性设置
当一个被绑定的数据的值发生改变时，Binding类会自动寻找该View上的绑定表达式上的方法去改变View，通过Google数据绑定框架我们可以去自定义这些方法。

对于一个xml的attribute，DataBinding会去寻找 setAttribute 方法，xml 属性的命名空间是没有关系的。比如TextView上的一个属性 `android:text`，会去寻找 `setText(String)`。如果表达式返回的是 `int` 则会去寻找 `setText(int)`，所以必须确保xml中表达式返回正确的数据类型，必要时需要数据转换。
我们可以比较容易地为任何属性创造出setter去使用DataBinding。比如support包下的 `DrawerLayout` 没有任何属性，但是却有很多setter，下面利用这些已有的setter中的一个：

    <android.support.v4.widget.DrawerLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:scrimColor="@{@color/scrim}"
        app:drawerListener="@{fragment.drawerListener}"/>

## 自定义属性
一些xml属性需要自己去定义并实现逻辑，那么我们可以使用 `BindingAdapter`、`BindingMethods`、 `BindingMethod` 注解去自定义个自己的 setter，三个注解，但是 `@BindingMethods` 和 `@BindingMethod` 需要一起使用，所以是有两种方式来实现自定义的属性：

* 方式1：使用 `@BindingAdapter` 方式
* 方式2：使用 `@BindingMethods` 和 `@BindingMethod` 相结合的方式

### 方式1：[使用](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/java/com/renj/databinding/bindingadapter/ImageViewAdapter.java) `@BindingAdapter`

    @BindingAdapter(value = {"url"})
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView).load(url).into(imageView);
    }

以上代码我们给 `ImageView` 控件自定义了一个 `url` 属性，那么在XML布局中使用 `ImageView` 控件时就可以直接使用该属性，并且会自动使用Glide加载图片( [以上代码的位置随意，建议写在一个新的独立类中](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/java/com/renj/databinding/bindingadapter/ImageViewAdapter.java) )：

    <ImageView
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:layout_marginTop="@dimen/default_line_space"
        app:url="@{url}" />

`@BindingAdapter` 说明：用于自定义属性，需要设置多个属性时可以这样写 `@BindingAdapter({"url","loading","error"})`；同时 `@BindingAdapter` 还有一个参数 `requireAll`，设置 `@BindingAdapter(value = {"url","loading","error"}, requireAll = false)` ，`requireAll` 的作用表示我们在 `@BindingAdapter` 中定义的所有属性是不是都需要在 xml 文件中进行设置，如果为 `true` ，表示定义的所有属性都需要在 xml 中设置，默认为 `true`，为 `false`表示可以在 xml 中不需要设置所有定义的属性。

### 方式2：使用 `@BindingMethods` 和 `@BindingMethod` [相结合的方式](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/java/com/renj/databinding/weight/MyTextView.java) ：

    @BindingMethods({
            @BindingMethod(type = MyTextView.class, attribute = "textChangeToast", method = "onTextChangeToast")
    })
    public class MyTextView extends android.support.v7.widget.AppCompatTextView {
        public MyTextView(Context context) {
            super(context);
        }

        public MyTextView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        public void onTextChangeToast(String content) {
            UIUtil.showToast(content);
        }
    }

* 说明：
    * type：要操作的属性属于哪个View类，类型为class对象，比如：ImageView.class
    * attribute：xml属性，类型为String ，比如："android:tint"
    * method：指定xml属性对应的set方法(触发方法)，类型为String，比如："setImageTintList"

**开发者自定义的@BindingAdapter和android自带的发生冲突时，DataBinding会优先采用开发者自定义的**

## 自定义双向绑定
前面我们说到了双向绑定，并提到了Android中可以直接使用双向绑定的一些控件，
但是当我们自定义控件时，默认并不会绑定属性。而单向(正向)绑定，我们可以使用 `@BindingAdapter`、`@BindingMethods`、 `@BindingMethod` 注解来自定义。

但是如果我们需要实现双向绑定，除了实现正向绑定外，还需要实现逆向绑定。DataBinding也为我们 [实现逆向绑定](https://github.com/itrenjunhua/AndroidDataBinding/tree/master/app/src/main/java/com/renj/databinding/weight) 提供了相关的注解：`@InverseBindingAdapter` 、 `@InverseBindingMethods` 、 `@InverseBindingMethod`，同样的有三个注解，但是 `@InverseBindingMethods` 和 `@InverseBindingMethod` 需要一起使用，所以是有两种方式来实现逆向绑定：

* 方式1：使用 `@InverseBindingAdapter` 方式
* 方式2：使用 `@InverseBindingMethods` 和 `@InverseBindingMethod` 相结合的方式

### 方式1：[使用](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/java/com/renj/databinding/weight/MySeekBar.java) `@InverseBindingAdapter`

`@InverseBindingAdapter` 需要与 `@BindingAdapter` 配合使用。

    public class MySeekBar extends android.support.v7.widget.AppCompatSeekBar {
        private static InverseBindingListener inverseBindingListener;

        public MySeekBar(Context context) {
            super(context, null);
            init();
        }

        public MySeekBar(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public MySeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init();
        }

        private void init() {
            this.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    // 触发反向数据的传递
                    if (inverseBindingListener != null)
                        inverseBindingListener.onChange();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }

        @BindingAdapter(value = "myProgress", requireAll = false)
        public static void setMyProgress(MySeekBar mySeekBar, int progress) {
            // 防止死循环
            if (getMyProgress(mySeekBar) != progress) {
                mySeekBar.setProgress(progress);
            }
        }

        @InverseBindingAdapter(attribute = "myProgress", event = "myProgressAttrChanged")
        public static int getMyProgress(MySeekBar mySeekBar) {
            return mySeekBar.getProgress();
        }

        @BindingAdapter(value = {"myProgressAttrChanged"}, requireAll = false)
        public static void setMyProgressAttrChanged(MySeekBar mySeekBar, InverseBindingListener inverseBindingListener) {
            if (inverseBindingListener != null) {
                MySeekBar.inverseBindingListener = inverseBindingListener;
            } else {
                Log.e("MySeekBar", "InverseBindingListener Null Exception");
            }
        }
    }

* 说明：
    * attribute：String 类型，必填，表示当值发生变化时，要从哪个属性中检索这个变化的值；例："android:text"
    * event： String 类型，非必填，如果填写，则使用填写的内容作为 event 的值；如果不填，在编译时会根据 attribute 的属性名再加上后缀 "AttrChanged" 生成一个新的属性作为 event 的值。作用： 当 View 的值发生改变时用来通知 dataBinding 值已经发生改变了。**开发者一般需要使用 `@BindingAdapter` 创建对应属性来响应这种改变（简单来说就是 `@InverseBindingAdapter` 注解的 event 值需要和`@BindingAdapter` 的 value 值相同，对被 `@BindingAdapter`  注解的方法名没有特殊要求，建议使用 setEventValue的方式[EevntValue表示]`@InverseBindingAdapter` 注解的 event 值名）**

### 方式2：使用 `@InverseBindingMethods` 和 `@InverseBindingMethod` [相结合的方式](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/java/com/renj/databinding/weight/MySeekBar2.java)

`@InverseBindingMethods` 和 `@InverseBindingMethod` 的使用 与`@BindingMethods` 和 `@BindingMethod` 的使用类似。

    @InverseBindingMethods({
            @InverseBindingMethod(type = MySeekBar2.class,attribute = "myProgress2",event = "myProgress2AttrChange",method = "getMyProgress2")
    })
    public class MySeekBar2 extends android.support.v7.widget.AppCompatSeekBar {
        private static InverseBindingListener inverseBindingListener;

        public MySeekBar2(Context context) {
            super(context, null);
            init();
        }

        public MySeekBar2(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public MySeekBar2(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init();
        }

        private void init() {
            this.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    // 触发反向数据的传递
                    if (inverseBindingListener != null)
                        inverseBindingListener.onChange();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }

        public void setMyProgress2(int progress) {
            // 防止死循环
            if (getMyProgress2() != progress) {
                setProgress(progress);
            }
        }

        public int getMyProgress2() {
            return getProgress();
        }

        public void myProgress2AttrChange(InverseBindingListener inverseBindingListener) {
            if (inverseBindingListener != null) {
                MySeekBar2.inverseBindingListener = inverseBindingListener;
            } else {
                Log.e("MySeekBar2", "InverseBindingListener Null Exception");
            }
        }
    }

* 说明：
    * type：要操作的属性属于哪个View类，类型为class对象，比如：ImageView.class
    * attribute：xml属性，类型为String ，比如："android:tint"
    * event： String 类型，非必填，如果填写，则使用填写的内容作为 event 的值；如果不填，在编译时会根据 attribute 的属性名再加上后缀 "AttrChanged" 生成一个新的属性作为 event 的值。比如，如果自己定义了attribute=”xxx”，那么Android系统自动会匹配查找xxxAttrChanged方法，该方法是set开头，那么就最终变成：setXxxAttrChanged；**如果开发者在event里面自己随意定义了一个方法名，那么必须严格一致确保类里面有这个方法，比如，如果用户在InverseBindingMethod的event里面任意定义了一个方法“abcdefg”，那么必须在该注解类有一个同名方法如setAbcdefg()（set是否有都能成功，但是建议加上）**。作用： 当 View 的值发生改变时用来通知 dataBinding 值已经发生改变了。
    * method：非必填。 如果未提供，则使用属性名称查找方法名称，前缀为“is”或“get”

## Converters 使用
使用`@BindingConversion`注解，作用：用于将表达式类型自动转换为setter中使用的值

有时候我们想这样写xml属性：

    <View
        android:id="@+id/view_converter"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@{status ? @color/color_converter_color1 : @color/color_converter_color2}" />

但是xml属性 `android:background` 的对应set方法 `setBackground()` 接收的参数是一个Drawable，那么就需要通过 `BindingConversion` 注解来实现转换：

    /**
     * 定义一个 Converter ，将 {@code int} 类型的 {@link android.graphics.Color} 转换为 {@link ColorDrawable}
     *
     * @param color
     * @return
     */
    @BindingConversion
    public static ColorDrawable colorToColorDrawable(int color) {
        return new ColorDrawable(color);
    }

* [以上代码的位置随意，建议写在一个新的独立类中](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/java/com/renj/databinding/conversters/ColorToColorDrawableConverter.java)

## [修改 Component](https://github.com/itrenjunhua/AndroidDataBinding/blob/master/app/src/main/java/com/renj/databinding/activity/MainActivity.java)

    DataBindingUtil.setDefaultComponent(new TestBindingComponent());

通过修改Component我们可以对指定的使用了DataBinding的控件属性进行统一修改，具体使用 [请查看代码](https://github.com/itrenjunhua/AndroidDataBinding/tree/master/app/src/main/java/com/renj/databinding/component)



