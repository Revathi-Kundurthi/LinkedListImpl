package operr.org;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class Node{
    public static int curr;
	int val;
    Node next;
    public Node(int value) {
        val = value;
        next = null;
    }
}

public class LinkedList {
	
public static void main(String[] args) {
      
    Node head = null;    
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int operation = 0;
    while(operation != 4){

        try {
        	
            System.out.println("Enter Option:\n 1: Append Element \n 2: Remove Tail Element \n 3: Remove Elements Greater than Target Element \n 4. Exit");
            operation = Integer.parseInt(br.readLine());
            
            switch (operation) {
            
            	case 1: //Append Element
            		System.out.println("Enter Value: ");
            		int val = Integer.parseInt(br.readLine());
            		head = appendElement(val,head);
            		display(head);
            		break;
                
            	case 2: // Remove Tail Element
            		head=removeTailElement(head);
            		display(head);
            		break;
                
            	case 3: // Remove Elements Greater than Target Element
            		head = removeRandomElement(head);
            		display(head);
            		break;
                
            	default:
            		System.out.println("Invalid Option");
            		break;
            	}
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
    	}
    System.out.println("Exited!!!");
    	try {
    		br.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}       
	}

static Node appendElement(int value, Node root){   
    Node temp = new Node(value);
    Node curr = root;
    if(root==null){
        return temp; // as root or first
    }
    else
    {
        while(curr.next!=null)
        {
            curr = curr.next;
        }
        curr.next = temp;
        return root;
    }               
}

static Node removeTailElement(Node root){
    if(root==null){
        System.out.println("List is Empty");
        return null;
    }
    Node curr = root;
    Node prev = null;
    if(root.next==null){
        return null; // remove root itself
    }
    else
    {
        while(curr.next!=null)
        {
            prev = curr;
            curr = curr.next;
        }
        prev.next=null;// remove last node
        return root;
    }               
}

public static Node removeRandomElement(Node head) {
   int index = new Random().nextInt();
  Node curr = head;
    Node prev = head;
    while(curr.next!=null) {
        prev = curr;
    }

    prev.next = curr.next;
    curr.next = null;

    return head;
    
}

static void display(Node root){
    System.out.println("Current List:");
    if(root==null){
        System.out.println("List is Empty");
        return;
    }
    while (root!=null){
        System.out.print(root.val+"->");
        root=root.next;
    }
    System.out.println();
}


}