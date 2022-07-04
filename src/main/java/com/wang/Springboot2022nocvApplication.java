package com.wang;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wang.dao")
//@MapperScan 作用：指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
//		添加位置：是在Springboot启动类上面添加，
public class Springboot2022nocvApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2022nocvApplication.class, args);
	}

}
