public class PageIndex {
	MyLinkedList<WordEntry> listofwe;
	PageIndex(){
		listofwe=new MyLinkedList<WordEntry>();
	}
   
	  public MyLinkedList<WordEntry> getWordEntries(){
    	  return listofwe;
      }
      public void addPositionForWord(String str,Position p)
      { Node<WordEntry> top=listofwe.getTop();
        boolean flag=false; 
      	while(top!=null){
      		if(top.getElement().getWord().equals(str))
      			{top.getElement().addPosition(p);
      		    flag=true;
      			break;
      			}
      		top=top.getNext();
      	}
      	if(!flag)
      	{   WordEntry newwd=new WordEntry(str);
      	    newwd.addPosition(p);
      	    listofwe.Insert(newwd);
      	}    		  
      }
}
