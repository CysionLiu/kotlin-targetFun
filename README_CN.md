## kotlin-targetFun

---

### TargetFun是一个基于Kotlin语言的安卓开发库，其主要目的是为了让开发者更简单的使用安卓SDK及部分第三方Lib中的多函数接口。 

**嗯，，多函数接口是啥？还是看代码介绍吧：**

使用本库后，你可以这样为EditText添加监听文本变化的接口：


	EditText(this)._addTextChangedListener {
            _onTextChanged { s, start, before, count ->
                //do sth
            }
        }
        //-- 或者这样
        EditText(this)._addTextChangedListener {
            _beforeTextChanged { s, start, count, after ->
                //do sth
            }
            _onTextChanged { s, start, before, count ->
                //do sth
            }
        }
        //-- 或者这样
        EditText(this)._addTextChangedListener {
            _onTextChanged { s, start, before, count ->
                //do sth
            }
            _afterTextChanged {
                //do sth
            }
        }


或者如果项目中用到了Rxjava，可以这样用Observer:

	
	Observable.just("1", "2", "3")
            ._subscribe {
                _onNext {
                    //do sth
                }
            }
        // 或者这样
        Observable.just("1","2","3")
            ._subscribe {
                _onNext {
                    //do sth
                }
                _onError { 
                    //do sth
                }
            }
        // 或者这样
        Observable.just("1","2","3")
            ._subscribe {
                _onNext {
                    //do sth
                }
                _onComplete {
                    //do sth
                }
            }


在kotlin中用过rxjava的应该知道，subscribe时虽然官方给了些lamada表达式快捷使用，但顺序和随机使用方法确实个令人困扰的问题，故有本方案。


### 目前版本支持的多函数接口如下

---

- TextWatcher
- ViewPager.OnPageChangeListener
- Animator.AnimatorListener
- AbsListView.OnScrollListener
- RecyclerView.OnScrollListener
- SeekBar.OnSeekBarChangeListener
- View.OnAttachStateChangeListener
- DrawerLayout.DrawerListener
- View.OnClickListener（filter)
- Observer (rx)
- FlowableSubscriber (rx)
- 一些彩蛋(๑*◡*๑)



###Setup

---

	repositories {
   		 jcenter()
	}

	dependencies {
   	 	implementation "com.cysion:targetfun:1.1.0"
	}

android studio 新版本默认 buildToolsVersion默认 28.0.2

###using TargetFun


本库目的既然是基于原SDK接口的优化使用，自然用法跟原接口特别相似，最明显的差别就是所有的方法都是以 '_'开头，虽然这与常见的java语言开发规范不同，但kotlin很灵活，特别是扩展函数，考虑到更好的使用和标识，所以方法以 _开头。

---
**TextWatcher**

<img src="gif/edittext.gif" width="80%" >

---
**OnPageChangeListener**

<img src="gif/viewpager.gif" width="80%" >

---
**OnSeekBarChangeListener**

<img src="gif/seekbar.gif" width="80%" >

---
**AnimatorListener**

<img src="gif/animator.gif" width="80%" >

---
**Observer**

<img src="gif/rx.gif" width="80%" >


**彩蛋**



//Edittext的扩展函数，打开/关闭键盘，还有hide..

	EditText(this).openKeyBoard()

	EditText(this).hideKeyBoard()

// 过滤频繁点击

	Button(this)._setOnClickListener {

        }

//跳转Activity,1000请求码

 	_startActivityForResult<EditExActivity>(1000)

	 _startActivity<EditExActivity>()


//str(resid),  drawable(resid)等方法

	TextView(this).text=str(R.string.app_name)


待补充...


###License

```

Copyright 2018 CysionLiu

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```













