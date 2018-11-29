package com.cysion.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.cysion.other.addTo
import com.cysion.sample.activity.*
import com.cysion.sample.data.PageData
import com.cysion.targetfun._subscribe
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_main_list.view.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    var datalist: MutableList<PageData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDataList()
        listView.apply {
            adapter = MyMainAdapter(datalist, this@MainActivity)
            setOnItemClickListener { parent, view, position, id ->
                startActivity(Intent(this@MainActivity, datalist[position].target))
            }
        }
        foo()
    }

    private fun initDataList() {
        datalist.add(PageData(EditTextActivity::class.java, "TextWatcher sample"))
        datalist.add(PageData(ViewPagerActivity::class.java, "OnPageChangeListener sample"))
        datalist.add(PageData(AnimatorActivity::class.java, "AnimatorListener sample"))
        datalist.add(PageData(ListActivity::class.java, "ListView sample"))
        datalist.add(PageData(RecyclerActivity::class.java, "RecyclerView sample"))
        datalist.add(PageData(SeekBarActivity::class.java, "SeekBar sample"))
        datalist.add(PageData(DrawerActivity::class.java, "DrawerListener sample"))
        datalist.add(PageData(OtherActivity::class.java, "Other extension function sample"))
    }

    override fun onStop() {
        super.onStop()
        com.dispose()
    }

    var com: CompositeDisposable = CompositeDisposable()
    fun foo() {
        Observable.interval(1, TimeUnit.SECONDS)
            .subscribe({
                logd(it.toString())
            }, {
                logd("error")
            },
                {
                    logd("finish")
                }).addTo(com)
        Observable.interval(1, TimeUnit.SECONDS)
            ._subscribe {
                _onNext {
                    logi(it.toString())
                }
                _onComplete {
                    logi("complete")
                }
                _onError {
                    logd(it.message.toString())
                }
            }.addTo(com)
//        val _subscribe = Observable.just(
//            PageData(MainActivity::class.java, "one"),
//            PageData(MainActivity::class.java, "two")
//        )
//            ._subscribe {
//                _onSubscribe {
//                    logd("_onSubscribe PageData")
//                }
//                _onNext {
//                    logd(it.name)
//                }
//            }

    }
}

private class MyMainAdapter(var data: MutableList<PageData>, var context: Context) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: Holder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_main_list, parent, false)
            holder = Holder(view.tvName)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as Holder
        }
        holder.item.text = data[position].name
        return view
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }
}

data class Holder(var item: TextView)