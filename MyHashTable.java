
public class MyHashTable {
	int size=26;
	HashEntry[] table;
	MyHashTable()
	{
		table=new HashEntry[size];
	}
	public int getHashIndex(String str){
		int hsindex=0;
		if(str.length()!=0)
			{int value=(int)str.charAt(0);
			hsindex=value%size;
			return hsindex;
			}
		return hsindex;
	}	
	public void addPositionsForWord(WordEntry w){
		int index=getHashIndex(w.getWord());
		HashEntry top=table[index];
		if(top==null){
			table[index]=new HashEntry(w);
		}
		else
			{	boolean flag=false;
				while(true)
				{
					if(top.getWE().getWord().equals(w.getWord()))
					{
						top.getWE().addPositions(w.getAllPositionsForThisWord());
						flag=true;
						break;
					}
					if(top.getNext()==null)
						break;
					top=top.getNext();
				}
				if(!flag)
				{
					top.setNext(new HashEntry(w));
				}
			}
	}
	public WordEntry getWordentryfromhashtable(String s)
	{   int hindex=getHashIndex(s);
		HashEntry top1=table[hindex];
		while(top1!=null){
			if(top1.getWE().getWord().equals(s))
				return top1.getWE();
			top1=top1.getNext();
		}
		return null;
		
	}
	
				
}
