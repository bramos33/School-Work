/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intlinkedbag;

/**
 *
 * @author bramo
 */
public class IntNode {
     private int data;
    private IntNode link;
    IntNode head;
    IntNode tail;
    
    public IntNode(int initialData, IntNode initialLink){
        data = initialData;
        link = initialLink;
    }
    
    public int getData(){
        return data;
    }
    public IntNode getLink(){
        return link;
    }
    public void setData(int newData){
        data = newData;
    }
    public void setLink(IntNode newLink){
        link = newLink;
    }
    public void addNodeAfter(int element){
        link = new IntNode(element, link);
    }
    public void removeNodeAfter(){
        link = link.link;
    }
    
    public static int listLength(IntNode head){
        IntNode cursor;
        int answer = 0;
        
        for(cursor = head; cursor != null; cursor = cursor.link){
            answer ++;
        }
        return answer;
    }
    
    public static IntNode listSearch(IntNode head, int target){
        IntNode cursor;
        
        for(cursor = head; cursor != null; cursor = cursor.link){
            if(target == cursor.data){
                return cursor;
            }
        }
        return null;
    }
    
    public static IntNode listPosition(IntNode head, int position){
        IntNode cursor;
        int i;
        if (position < 0){
            throw new IllegalArgumentException("position is not positive");
        }
        cursor = head;
        for(i = 1;(i < position) && (cursor != null); i++){
            cursor = cursor.link;
        }
        return cursor;
    }
    
    public static IntNode listCopy(IntNode source){
        if(source == null){
            return null;
        }
        IntNode copyHead;
        IntNode copyTail;
        copyHead = new IntNode(source.data, null);
        copyTail = copyHead;
        while(source.link != null){
            source = source.link;
            copyTail.addNodeAfter(source.data);
            copyTail = copyTail.link;
        }
        return copyHead;
    }
    
    public static IntNode[] listCopyWithTail(IntNode source){
        IntNode copyHead;
        IntNode copyTail;
        IntNode[] answer = new IntNode[2];
        if(source == null){
            return null;
        }
        copyHead = new IntNode(source.data, null);
        copyTail = copyHead;
        while(source.link != null){
            source = source.link;
            copyTail.addNodeAfter(source.data);
            copyTail = copyTail.link;
        }
        answer[0] = copyHead;
        answer[1] = copyTail;
        return answer;
    }
    
}
