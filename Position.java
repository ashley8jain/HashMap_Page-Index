
public class Position{
	PageEntry pe;
	int wi;
	public Position(PageEntry p,int wordIndex)
	{  pe=p;
	   wi=wordIndex;
	}
	public PageEntry getPageEntry(){
		return pe;
	}
	public int getWordIndex(){
		return wi;
	}
}
