package com.my.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 * @Author: YST
 * @Date: 2021/6/7 1:49
 * @Version: 1.0
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        MongoDatabase tl = MongoDBUtil.getDb("tl");

        //获取集合
        MongoCollection<Document> user = tl.getCollection("user");

        //创建文档
        Document document = new Document("name","张三")
                .append("sex", "男")
                .append("age", 18);

        user.insertOne(document);

        Bson eq = Filters.eq("age", 12);
        user.deleteMany(eq);

        

    }

}
