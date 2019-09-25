package com.hjy.LearnStudy.JavaStudy.NoticeCount;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

/**
 * @author huangjunyan
 * @date 2019-07-16 10:36
 */
public class NoticeEInteract {
    public static void main(String[] args){
        noticeNewMsg();
    }

    public static void noticeNewMsg(){
        Map<String,Integer> map = new HashMap<>();
        int i = 1;
        while(true) {
            try {
                System.out.println(new Date().toString()+i++);
                Thread.sleep(1000);
                Set<String> userSet = new HashSet<>();
                userSet.add("天地源");
                userSet.add("有友食品");
                Document doc = Jsoup.connect("https://sns.sseinfo.com/ajax/feeds.do?type=11&pageSize=100&lastid=-1&page=1&_=1563244843").get();
//        System.out.println(doc);
                Elements links = doc.select(".m_feed_detail").select(".m_qa");

                for (Element link : links) {
                    Elements linkHref = link.getElementsByClass("m_feed_face");
                    Elements link2 = link.getElementsByClass("m_feed_cnt");
                    String username = linkHref.text();
                    Integer count = map.getOrDefault(username,1);
                    map.put(username,++count);
//                    if(userSet.contains(username)) {
                    System.out.println(linkHref.text());
                    System.out.println("有需求账户回复消息啦");
//                    }
                }

            }catch (Exception e) {

            }
        }
    }
}