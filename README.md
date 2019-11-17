## kotlin-targetFun

---

[中文请看这里](./README_CN.md)

### Kotlin library for Android providing useful extensions to simplify interface callback in Android SDK. 

**Eh...Code is more expressive ：**

Using this lib,  you can add a TextWather to an EditText just like this：


	EditText(this).withTextChangedListener {
            ifTextChanged { s, start, before, count ->
                //do sth
            }
        }

or like this

	
	EditText(this).withTextChangedListener {
            ifBeforeTextChanged { s, start, count, after ->
                //do sth
            }
            ifTextChanged { s, start, before, count ->
                //do sth
            }
        }

or like this

 	EditText(this).withTextChangedListener {
            ifTextChanged { s, start, before, count ->
                //do sth
            }
            ifAfterTextChanged {
                //do sth
            }
        }


**if you have used Rxjava in your project, you can use Observer like this:**

	
	Observable.just("1", "2", "3")
            .withSubscribe {
                ifNext {
                    //do sth
                }
            }
or like this

 	Observable.just("1","2","3")
            .withSubscribe {
                ifNext {
                    //do sth
                }
                ifError {
                    //do sth
                }
            }

or like this

 	Observable.just("1","2","3")
            .withSubscribe {
                ifNext {
                    //do sth
                }
                ifComplete {
                    //do sth
                }
            }





### Support Interfaces



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
- Painted eggshell(๑*◡*๑)



### Setup



	repositories {
   		 jcenter()
	}

	dependencies {
   	 	implementation "com.cysion:targetfun:1.2.0"
	}

buildToolsVersion is default  28.0.2 in Android Studio lastest version 

### using TargetFun


Note that all methods to set or add callback in the lib start with 'with' ,
and the method in '{}' start with 'if'.



**Painted eggshell**



Edittext extension funtion，open/hide keyboard

	EditText(this).openKeyBoard()

	EditText(this).hideKeyBoard()

filter too frequent click event

	Button(this).clickWithLimit {
	}

jump to Activity, 1000 is one requestcode 

	gotoActivityForResult<EditExActivity>(1000)

	gotoActivity<EditExActivity>()


str(resid),  drawable(resid),color(resid)

	TextView(this).text=str(R.string.app_name)



todo...


### License

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













