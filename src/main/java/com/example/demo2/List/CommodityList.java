package com.example.demo2.List;

public class CommodityList {
    String CommodityName;
    String CommodityPrice;
    byte[] CommodityImg;
    public CommodityList() {
    }

    public CommodityList(String commodityName, String commodityPrice, byte[] commodityImg) {
        CommodityName = commodityName;
        CommodityPrice = commodityPrice;
        CommodityImg = commodityImg;
    }

    public String getCommodityName() {
        return CommodityName;
    }

    public void setCommodityName(String commodityName) {
        CommodityName = commodityName;
    }

    public String getCommodityPrice() {
        return CommodityPrice;
    }

    public void setCommodityPrice(String commodityPrice) {
        CommodityPrice = commodityPrice;
    }

    public byte[] getCommodityImg() {
        return CommodityImg;
    }

    public void setCommodityImg(byte[] commodityImg) {
        CommodityImg = commodityImg;
    }
}
