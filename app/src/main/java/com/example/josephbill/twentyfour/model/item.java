package com.example.josephbill.twentyfour.model;

import java.util.List;

/**
 * Created by Joseph Bill on 2/14/2018.
 */

public class item {
    public String title;
    public String pubDate;
    public String link;
    public String guid;
    public String author;
    public String thumbnail;
    public String description;
    public String content;
    public Object enclosure;
    public List<String> categories;


    public item(String title, String pubDate, String link, String guid, String author, String thumbnail, String description, String content, Object enclosure, List<String> categories) {
    }
        public String getTitle(){
            return title;
        }

    public void setTitle(String title) {
        this.title = title;

    }

    public String getPubDate (){
        return pubDate;
    }

    public void setPubDate (String pubDate){
        this.pubDate = pubDate;
    }

    public String getLink (){
        return link;
    }

    public void setLink (String link){
        this.link = link;
    }
    public String getGuid (){
        return guid;
    }

    public void setGuid (String guid){
        this.guid = guid;
    }
    public String getAuthor (){
        return author;
    }

    public void setAuthor (String author){
        this.author = author;
    }
    public String getThumbnail (){
        return thumbnail;
    }

    public void setThumbnail (String pubDate){
        this.thumbnail = thumbnail;
    }

    public String getDescription (){
        return description;
    }

    public void setDescription (String description){
        this.description= description;
    }


    public String getContent (){
        return content;
    }

    public void setContent (String content){
        this.content = content;
    }

    public Object getEnclosure (){
        return enclosure;
    }

    public void setEnclosure (Object enclosure){
        this.enclosure = enclosure;
    }

    public List<String> getItems(){
        return categories;
    }
    public void setItems (List<item> items){
        this.categories = categories;
    }


}