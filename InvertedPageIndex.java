
public class InvertedPageIndex {
	MyHashTable mht;
	MySet<PageEntry> pset;
	InvertedPageIndex(){
		pset=new MySet<PageEntry>();
		mht=new MyHashTable();
	}
	public void addPage(PageEntry p){
		pset.addElement(p);
		Node<WordEntry> topoflistofword=p.getPageIndex().getWordEntries().getTop();
		while(topoflistofword!=null){
			mht.addPositionsForWord(topoflistofword.getElement());
			topoflistofword=topoflistofword.getNext();
		}		
	}
	
	public MySet<PageEntry> getPagesWhichContainsWord(String str){
		MySet<PageEntry> pagewhichcontainingwords=new MySet<PageEntry>();
		WordEntry foundwe=mht.getWordentryfromhashtable(str);
		if(foundwe==null)
			return null;
		Node<Position> top=foundwe.getAllPositionsForThisWord().getTop();
		while(top!=null)
		{
			pagewhichcontainingwords.addElement(top.getElement().getPageEntry());
			top=top.getNext();
		}
		
		return pagewhichcontainingwords;
	}
	public MyLinkedList<Position> FindPositionsOfWordInAPage(String wd,String pagename)
	{   MyLinkedList<Position> listofposition=new MyLinkedList<Position>();
		WordEntry foundwde=mht.getWordentryfromhashtable(wd);
		
		if(foundwde==null)
			return null;
		Node<Position> tmp=foundwde.getAllPositionsForThisWord().getTop();
		while(tmp!=null)
		{
			if(tmp.getElement().getPageEntry().getPageName().equals(pagename))
				listofposition.Insert(tmp.getElement());
			tmp=tmp.getNext();
		}
		return listofposition;
	}
	public MySet<PageEntry> getsetofpe()
	{
		return pset;
	}
	

}
