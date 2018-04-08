package com.example.josephbill.twentyfour.model;

import java.util.List;

/**
 * Created by Joseph Bill on 2/14/2018.
 */







    public class Rssobject{
        public String status;
        public Feed feed;
        public List<item> items;

        public Rssobject( String status, Feed feed, List<item> items){
            this.status = status;
            this.feed = feed;
            this.items = items;

    }
  public String getStatus(){
      return status;
  }
  public void setStatus (String status){
      this.status = status;
  }
        public Feed getFeed(){
            return feed;
        }
        public void setFeed (Feed feed){
            this.feed = feed;
        }

        public List<item> getItems(){
            return items;
        }
        public void setItems (List<item> items){
            this.items = items;
        }

}
