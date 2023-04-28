package com.bookstore.devbook.processor;

import com.bookstore.devbook.model.Book;
import com.bookstore.devbook.utils.Cart;
import com.bookstore.devbook.utils.GlobalConstant;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class CartProcessor {

    /** <This method process the Cart data and make data in group format  for applying the discount**/
    public List<List> processCart() {

        Map groupByBook = Cart.getCart().stream().collect(Collectors.groupingBy(Book :: getName, () -> new TreeMap<>(Collections.reverseOrder()), Collectors.toList()));
        List<List> groups = new ArrayList();
        Object [] lists = groupByBook.values().toArray();
         while(checkAllListEmpty(lists)){
             makeGroup(groupByBook, groups);
         }

        if(!groups.isEmpty() && groups.get(0).size() >= GlobalConstant.MAW_NUM_GROUP) {
            return formatGroup(groups);
        }
        return groups;
    }

    private void makeGroup(Map groupByBook , List<List> groups){

        for (int i = 0; i < groupByBook.size(); i++) {
            List<Book> group = new ArrayList();
            groupByBook.keySet().stream().forEach(key-> { List<Book> list = (List) groupByBook.get(key);
                if (!list.isEmpty()) {
                    group.add(list.get(0));
                    list.remove(0);
                }});
            if(!group.isEmpty())
                groups.add(group);
        }

        groupByBook.keySet().stream().forEach(key-> { List<Book> list = (List) groupByBook.get(key);
            if (!list.isEmpty()) {
                list.stream().forEach(e-> {
                    List<Book> singleBook =new ArrayList();
                    singleBook.add(e) ;
                    groups.add(singleBook);
                });
                list.clear();
            }});
    }

    private boolean checkAllListEmpty(Object [] lists){
        boolean check = false;
        for(Object obj : lists){
            List list = (List)obj;
            if(list.size() != 0) {
                check = true;
                break;
            }
        }
        return check;
    }

    private List<List> formatGroup(List<List> groups){
        List<Book> group = groups.get(0);
        for (int i=1;i<groups.size();i++) {
            if(groups.get(i).size() == GlobalConstant.GROUP_SHIFT_INDEX){
                List<Book> list = groups.get(i);
                Book book = null ;
                for(Book book10 : group){
                    if( !list.contains(book10)) {
                        book = book10;
                        break;
                    }
                }
                list.add(book);
                group.remove(book);
            }
        }
        return groups;
    }
}
