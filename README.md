#ExpandLayout

## 简介
由于界面View.VISIBLE和View.GONE的动画太生硬，所以写了ExpandLayout类来平滑过渡。
基本思路，动态的设置布局的高度。

- 核心动画效果代码

```java
    /**
     * 切换动画实现
     */
    private void animateToggle(long animationDuration) {
        ValueAnimator heightAnimation = isExpand ?
                ValueAnimator.ofFloat(0f, viewHeight) : ValueAnimator.ofFloat(viewHeight, 0f);
        heightAnimation.setDuration(animationDuration / 2);
        heightAnimation.setStartDelay(animationDuration / 2);

        heightAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float val = (float) animation.getAnimatedValue();
                setViewHeight(layoutView, (int) val);
            }
        });

        heightAnimation.start();
    }
```

## 效果预览

![图片](https://github.com/ss518926/ExpandLayout/raw/master/image/expand.gif)


## 使用
因为ExpandLayout继承RelativeLayout，所以可以在布局内直接包含控件

- 布局文件中

```xml
 <com.seselin.View.ExpandLayout
        android:id="@+id/expandLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#FFFF00"
        android:clickable="true">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:padding="15dp"
            android:text="这里是可收缩布局内部" />

    </com.seselin.View.ExpandLayout>
```

- java代码中
  初始状态是否显示，toggleExpand切换**折叠/展开**状态

```java
    private ExpandLayout mExpandLayout;

    public void initExpandView() {
        mExpandLayout = (ExpandLayout) findViewById(R.id.expandLayout);
        mExpandLayout.initExpand(false);//设定初始化折叠，默认展开
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mExpandLayout.toggleExpand();
            }
        });
    }
```

[项目地址](https://github.com/ss518926/ExpandLayout)