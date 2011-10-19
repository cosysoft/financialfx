/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.cosysoft.labs.financialfx.util;

import java.util.List;

/**
 *
 * @author wb-yaolantian
 */
public class CollectionUtil {
    public static <T> boolean isEmpty(List<T> list){
        return !(list!=null&&list.size()>0);
    }
    
    
}
