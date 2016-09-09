
public class WordEntry {
	String wd;
	MyLinkedList<Position> post;
	WordEntry(){
		wd=null;
		post=new MyLinkedList<Position>();
	}
	WordEntry(String word)
	{
		wd=word;
		post=new MyLinkedList<Position>();
	}
	public String getWord()
	{
		return wd;
	}
	public void addPosition(Position position)
	{ post.Insert(position);		
	}
	public void addPositions(MyLinkedList<Position> positions)
	{ 
		Node<Position> top=positions.getTop();
		while(top!=null)
		{ post.Insert(top.getElement());
		  top=top.getNext();	
		}
	}
	public MyLinkedList<Position> getAllPositionsForThisWord()
	{
		return post;
	}

}
