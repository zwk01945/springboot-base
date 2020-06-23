package com.example.thread.general.computed;

import com.example.thread.bean.CoustomerZt;
import com.example.thread.dao.CoustomerZtDao;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: OneBillon <br/>
 * Description: 插入100w条数据
 * date: 2020/6/23 13:52<br/>
 *
 * @author zwk<br />
 */
public class OneBillon implements Runnable{

    private static long count = 1000000L;
    private List<CoustomerZt> list = new ArrayList<CoustomerZt>();
    private CoustomerZtDao coustomerZtDao = null;


    public OneBillon(CoustomerZtDao coustomerZtDao) {
        this.coustomerZtDao = coustomerZtDao;
    }

    private synchronized void countInsert() {
        list.clear();
        long counttemp = 20;
        for (long i = count; count > 0; count--) {
            CoustomerZt coustomerZt = new CoustomerZt();
            coustomerZt.setProvinceFlag(0);
            coustomerZt.setName("测试人员" + (count - i));
            coustomerZt.setJob("测试工作");
            coustomerZt.setAge(0);
            coustomerZt.setLocalAddress("测试地址");
            list.add(coustomerZt);
        }
        long l = coustomerZtDao.insertList(list);

    }


    @Override
    public void run() {
        countInsert();
    }
}
