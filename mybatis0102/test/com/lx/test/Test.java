package com.lx.test;

import com.lx.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class Test
{
    public static void main(String[] args) throws Exception{
        //读取mybatis配置文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        //根据配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //得 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//表示自动提交发送DML语句
        //通过sqlSession发送配置文件中的SQL语句
        Dept dept = new Dept(11,"Java部","柏林");
;
       // int result = sqlSession.insert("deptmapper.add",dept);
      //  int result = sqlSession.update("deptmapper.update",dept);
        int result = sqlSession.delete("deptmapper.delete",14);
        System.out.println(result);
//        sqlSession.commit();
      // Dept dept =  sqlSession.selectOne("deptmapper.findOne",1);
    //    System.out.println("dept = " + dept);
     /*   List<Dept> deptList = sqlSession.selectList("deptmapper.findAll");
        System.out.println(deptList);*/
    }
}
