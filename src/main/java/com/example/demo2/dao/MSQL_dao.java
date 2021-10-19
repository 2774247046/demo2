package com.example.demo2.dao;

import com.example.demo2.List.CommodityList;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MSQL_dao {
    public List<CommodityList> All(){
        List<CommodityList>list=new ArrayList<>();
        try {
            Connection connection=Connection_dao.connection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select*from xy");
            while (resultSet.next()){
                CommodityList commodityList=new CommodityList();
                commodityList.setCommodityName(resultSet.getString(2));
                commodityList.setCommodityPrice(resultSet.getString(3));
                commodityList.setCommodityImg(resultSet.getBytes(4));
                list.add(commodityList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void Insert(CommodityList list){
        try {
            Connection connection=Connection_dao.connection();
            PreparedStatement ps=connection.prepareStatement("insert into xy(CommodityName,CommodityPrice,CommodityImg)values(?,?,?)");
            Object[]objects={list.getCommodityName(),list.getCommodityPrice(),list.getCommodityImg()};
            for (int i=0;i<objects.length;i++){
                ps.setObject(i+1,objects[i]);
            }
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        MSQL_dao dao=new MSQL_dao();
        CommodityList list=new CommodityList();
        try {
            File file = new File("E:\\Android\\daimazhusho\\app\\src\\main\\res\\mipmap-mdpi\\t.jpg");
            FileInputStream in = new FileInputStream(file);
            list.setCommodityName("Nike KD13 cw4115 103 杜兰特 13 贝多芬 白");
            list.setCommodityPrice("1999");
            byte[] a=new byte[1024];
            ByteArrayOutputStream out=new ByteArrayOutputStream();
            int len;
            byte[] c = new byte[0];
            while ((len=in.read(a))!=-1){
                out.write(a,0,len);
                c=out.toByteArray();
            }
            list.setCommodityImg(c);
            dao.Insert(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        List<CommodityList>list=dao.All();
//        byte []a=new byte[0];
//        for (int i=0;i<list.size();i++){
//            CommodityList commodityList=list.get(i);
//            System.out.println(commodityList.getCommodityName());
//            System.out.println(commodityList.getCommodityPrice());
//            System.out.println(commodityList.getCommodityImg());
//            a=commodityList.getCommodityImg();
//        }
//        File file=new File("E://AAA/w.png");
//        try {
//            FileOutputStream outputStream1=new FileOutputStream(file);
//            outputStream1.write(a);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
