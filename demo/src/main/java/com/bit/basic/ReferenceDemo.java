package com.bit.basic;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/*
   下面代码演示引用被回收后， ReferenceQueue能够接到原来对象被gc回收的事件通知。
 */
public class ReferenceDemo {

//    public static void main(String[] args) {
//        String str = new String("hello");
//        ReferenceQueue rq = new ReferenceQueue();
//        WeakReference wf = new WeakReference(str, rq);
//        str = null;
//
//        //两次催促垃圾回收器工作，提高"hello"对象被回收的可能性
//        System.gc();
//        checkQueue(rq);
//        System.gc();
//        checkQueue(rq);
//        Object str1=wf.get(); //⑦ 假如"hello"对象被回收，str1为null
//        if(str1 != null && !"".equals(str1)) {
//            System.out.println("str1 is " + str1);
//        } else {
//            System.out.println("str1 is null");
//        }
//        //ref = rq.poll();
//    }

//    public static void main(String[] args) {
//        WeakHashMap whm = new WeakHashMap();
//        String key = "Hello ";
//        String value = "World.";
//        whm.put(key, value);
//        System.out.println("before:" + whm.keySet().size());
//        System.gc();
//        System.out.println("after:" + whm.keySet().size());
//
//    }

    //    public static void checkQueue(ReferenceQueue rq) {
//        Reference inq = rq.poll();
//        // 从队列中取出一个引用
//        if (inq != null)
//            System.out.println("In queue: " + inq + " : " + inq.get());
//        else
//            System.out.println("In queue: is null." );R
//    }

    public static volatile boolean isRun = true;

    public static void main(String[] args) throws InterruptedException {
        String abc = new String("abc");
        System.out.println(abc.getClass() + "@" + abc.hashCode());
        final ReferenceQueue<String> referenceQueue = new ReferenceQueue<String>();
        new Thread(() -> {
            while (isRun) {
                Object obj = referenceQueue.poll();
                if (obj != null) {
                    try {
                        Field rereferent = Reference.class.getDeclaredField("referent");
                        rereferent.setAccessible(true);
                        Object result = rereferent.get(obj);
                        System.out.println("gc will collect："
                                + result.getClass() + "@"
                                + result.hashCode() + "\t"
                                + (String) result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        PhantomReference<String> abcWeakRef = new PhantomReference<String>(abc, referenceQueue);
        abc = null;
        Thread.sleep(1000);//等一下正在启动的线程
        System.gc();
        Thread.sleep(1000);//gc过快
        abcWeakRef.clear();
        isRun = false;
    }
}
