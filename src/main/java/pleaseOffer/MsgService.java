package pleaseOffer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MsgService {
    private volatile static AtomicInteger curNum; // 短信总数量

    private static int curbatch = 0; // 当前批次号

    private ConcurrentHashMap<Integer,List<Msg>> map = new ConcurrentHashMap<>(); // 批次消息

    private final Object mutexObj= new Object();



    // 接口短信通知服务

    void msgNotifyService(String name, String phone, Boolean result){

     curNum.getAndAdd(1); // 短信总数递增

     int batch = curNum.get() / 100; // 此信息批次号

     if(batch > curbatch) {
         synchronized(mutexObj){
            curbatch = batch;
         }
     }

     Msg msg = new Msg();
     List<Msg> lists = map.getOrDefault(batch, new ArrayList<>());
     lists.add(msg);

     map.put(batch, lists);

    }


    // 发送消息线程
    //  入口开启发送消息线程服务
    class ThirdSendService implements Runnable {

        public void run() {

            while(true) {

                for(Map.Entry<Integer, List<Msg>> entry : map.entrySet()) {

                    if(entry.getValue().size() >= 100) {

                        // 调用三方服务  发送List<Msg>
                        // 发送这一批之后清理内存
                        map.remove(entry.getKey());
                    }
                 }
            }
        }
    }

}


class Msg{ // 调用三方服务发送的消息体

   private String name;

   private String phone;
   private boolean result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}