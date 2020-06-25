package com.example.thread.general.computed.insert;

import com.example.thread.bean.CoustomerZt;
import com.example.thread.dao.CoustomerZtDao;
import net.minidev.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: OneBillon <br/>
 * Description: 插入100w条数据
 * date: 2020/6/23 13:52<br/>
 *
 * @author zwk<br />
 */
public class OneBillon {

    private long count = 1000000L;
    private List<CoustomerZt> list = new ArrayList<CoustomerZt>();
    private CoustomerZtDao coustomerZtDao = null;

    public OneBillon() {
    }

    public OneBillon(CoustomerZtDao coustomerZtDao) {
        this.coustomerZtDao = coustomerZtDao;
    }

    public  void countInsert() {
        while (true){
            synchronized(this){
                if (list.size() == 500000) {
                    coustomerZtDao.insertList(list);
                    list.clear();
                }
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "线程添加第" + count + "用户");
                    CoustomerZt coustomerZt = new CoustomerZt();
                    coustomerZt.setProvinceFlag(0);
                    coustomerZt.setName("测试人员" + count);
                    coustomerZt.setJob("测试工作");
                    coustomerZt.setAge(0);
                    coustomerZt.setLocalAddress("测试地址");
                    list.add(coustomerZt);
                    count = count -1;
                } else {
                    break;
                }
            }
        }
    }

}
