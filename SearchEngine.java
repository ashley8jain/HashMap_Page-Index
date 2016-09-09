import java.io.IOException;

public class SearchEngine{
	InvertedPageIndex ipi;
	MyHashTable ht;
	PageEntry updatingword=new PageEntry();
	public SearchEngine() {
		ipi=new InvertedPageIndex();
		ht=new MyHashTable();
	}
public boolean checkPage(String pn)
{
    MySet<PageEntry> peset=ipi.getsetofpe();
    Node<PageEntry> tp=peset.getTop();
    while(tp!=null)
    {
    	if(tp.getElement().getPageName().equals(pn))
    		return true;
    	tp=tp.getNext();
    }
	return false;
}

	public void performAction(String actionMessage) throws IOException {

		String[] action=actionMessage.split(" ");
		if(action[0].equals("addPage")){
			PageEntry addpage=new PageEntry(action[1]);
			ipi.addPage(addpage);
		}
		else if(action[0].equals("queryFindPositionsOfWordInAPage")){
			System.out.print(actionMessage+": ");
			if(action[1].charAt(action[1].length()-1)=='s')
				action[1]=action[1].substring(0,action[1].length()-1);
			String updatedwrd=updatingword.update1(action[1]);
			MyLinkedList<Position>	listofpositionwhichcontainingword=ipi.FindPositionsOfWordInAPage(updatedwrd,action[2]);
			
			if(!checkPage(action[2]))
				throw new  IOException("Given Webpage is not found!!!");
			Node<Position> topofposition=listofpositionwhichcontainingword.getTop();
			if(topofposition==null)
				throw new IOException("Given word is not found in given page");
			while(topofposition!=null)
			{   System.out.print(topofposition.getElement().getWordIndex());
			    if(topofposition.getNext()!=null)
			    	System.out.print(",");
				topofposition=topofposition.getNext();
			}
			System.out.println("");
		}
		else if(action[0].equals("queryFindPagesWhichContainWord")){
			System.out.print(actionMessage+": ");
			if(action[1].charAt(action[1].length()-1)=='s')
				action[1]=action[1].substring(0,action[1].length()-1);
			String updatedword=updatingword.update1(action[1]);
			MySet<PageEntry> setofpageentrycontainingword=ipi.getPagesWhichContainsWord(updatedword);
			if(setofpageentrycontainingword==null)
				throw new IOException("Given word is not available in all pages!!!!");
			Node<PageEntry> topoflistofpageentry=setofpageentrycontainingword.getTop();
			while(topoflistofpageentry!=null)
			{
				System.out.print(topoflistofpageentry.getElement().getPageName());
				if(topoflistofpageentry.getNext()!=null)
					System.out.print(",");
				topoflistofpageentry=topoflistofpageentry.getNext();				
			}
			System.out.println("");
		}
		else{
			throw new IOException("Incorrect query!!!");
		}
	}
}
