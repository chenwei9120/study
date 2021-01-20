package com.bit;

import com.bit.util.SpringManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.Scanner;


@SpringBootApplication(scanBasePackages = {"com.bit.controlloer","com.bit.basic",
        "com.bit.service", "com.bit.config","com.bit.interceptor", "com.bit.annotation"})
//@SpringBootApplication//(exclude = {com.bit.controlloer.TestController.class})
public class DemoApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        SpringManager.init(context);

        //WayConfig objWayConfig = context.getBean("conifgName", WayConfig.class);

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("addShutdownHook event.");
        }));
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            if(scanner.nextLine().equals("exit")) {
                System.exit(0);
            }
        }

    }

//    public static void main(String[] args) {
//        ApplicationContext ctx = new SpringApplicationBuilder()
//                .sources(DemoApplication.class)
//                .web(WebApplicationType.NONE) // 没错，把项目设置成非web环境
//                .run(args);
//        ((ConfigurableApplicationContext) ctx).start();
//    }
}

