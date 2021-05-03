package com.zjy.job.carretnal;

import com.zjy.job.carrental.CarrentalApplication;
import com.zjy.job.carrental.common.RandomUtil;
import com.zjy.job.carrental.common.exception.ServiceException;
import com.zjy.job.carrental.service.impl.CarRentalService;
import com.zjy.job.carrental.vo.OrderVo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarrentalApplication.class)
class CarrentalApplicationTests {
    @Autowired
    private CarRentalService carRentalService;
    private int threadCount = 50; //子线程数

    private CountDownLatch countDownLatch = new CountDownLatch(threadCount);

    @Test
    void contextLoads() {
        RandomUtil.generateOrderCode();
    }

    @Test
    void testGenerateOrderCode() {
        RandomUtil.generateOrderCode();
    }

    @Test
    void testReserveCar() {
        // 租赁2日
        OrderVo order = new OrderVo();
        order.setUserId(6); // eric
        order.setStartTime(2021050301);
        order.setEndTime(2021050401);
        order.setModelId(2);// toyota camery
        order.setPrice(new BigDecimal(400));
        try {
            OrderVo newOrder = carRentalService.reserveCarWithReentrantLock(order);
            Assert.assertNotNull(newOrder.getOrderNo());
        } catch (ServiceException e) {
            e.printStackTrace();
            Assert.assertNotNull(null);
        }
    }

    @Test
    void testReserveCarConcurrent() {
        for (int a = 1; a <= threadCount; a++) {
            MyThread myThread = new MyThread(this.countDownLatch);
            Thread thread = new Thread(myThread);
            thread.start();
        }
        try {
            countDownLatch.await(); //主线程等待 ,直到countDownLatch 为0
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    class MyThread implements Runnable{
        private CountDownLatch countDownLatch;

        public MyThread(CountDownLatch countDownLatch){
            this.countDownLatch=countDownLatch;
        }

        @Override
        public void run(){
            //执行业务代码
            // 租赁2日
            OrderVo order = new OrderVo();
            order.setUserId(6); // eric
            order.setStartTime(2021050301);
            order.setEndTime(2021050401);
            order.setModelId(3);// toyota camery
            order.setPrice(new BigDecimal(400));
            try {
                OrderVo newOrder = carRentalService.reserveCarWithReentrantLock(order);
                Assert.assertNotNull(newOrder.getOrderNo());
            } catch (ServiceException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
    }
}
