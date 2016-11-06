package com.example.lovely.lovelybookreader.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lovely on 16/11/2.
 */

public class BookShow implements Serializable{
        public List<RecommendBooks> books;

        public static class RecommendBooks implements Serializable {
                public String get_id() {
                        return _id;
                }

                public String getAuthor() {
                        return author;
                }

                public String getCover() {
                        return cover;
                }

                public String getShortIntro() {
                        return shortIntro;
                }

                public String getTitle() {
                        return title;
                }

                public boolean isTop() {
                        return isTop;
                }

                public boolean isHasCp() {
                        return hasCp;
                }

                public boolean isSeleted() {
                        return isSeleted;
                }

                public boolean isShowCheckBox() {
                        return showCheckBox;
                }

                /**
                 * _id : 526e8e3e7cfc087140004df7
                 * author : 太一生水
                 * cover : /agent/http://image.cmfu.com/books/3347382/3347382.jpg
                 * shortIntro : 十大封号武帝之一，绝世古飞扬在天荡山脉陨落，于十五年后转世重生，化为天水国公子李云霄，开启了一场与当世无数天才相争锋的逆天之旅。武道九重，十方神境，从此整个世界...
                 * title : 万古至尊
                 * hasCp : true
                 * latelyFollower : 3053
                 * retentionRatio : 42.59
                 * updated : 2016-07-25T15:29:51.703Z
                 * chaptersCount : 2406
                 * lastChapter : 第2406章 千载风云尽付一笑（大结局）
                 */

                public String _id;
                public String author;
                public String cover;
                public String shortIntro;
                public String title;
                public boolean hasCp;
                public boolean isTop = false;
                public boolean isSeleted = false;
                public boolean showCheckBox = false;
                public boolean isFromSD = false;
                public String path = "";
                public int latelyFollower;
                public double retentionRatio;
                public String updated = "";
                public int chaptersCount;
                public String lastChapter;
                public String recentReadingTime = "";
        }


}
