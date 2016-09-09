import java.io.*;
public class PageEntry{
	PageIndex pi;
	String pagename;
	BufferedReader br=null;
	PageEntry()
	{
		pi=null;
		pagename=null;
	}
	PageEntry(String pageName) throws IOException{
		pagename=pageName;
		pi=new PageIndex();

		try{
			br=new BufferedReader(new FileReader("webpages/"+pageName));
		   }
		catch(IOException e){
			e.printStackTrace();
		}
		String Sentence;
		int j=1;
		while((Sentence=br.readLine())!=null)
		{
			String[] Word=update(Sentence);
			for(int i=0;i<Word.length;i++)
			{
				if((!Word[i].matches("a|an|the|they|these|this|for|is|are|was|of|or|and|does|will|whoose")))
				    {
						pi.addPositionForWord(Word[i],new Position(this,j));
					}
						j++;
			}
		}
	}
	
	public PageIndex getPageIndex(){
		return pi;
	}
	public String getPageName(){
		return pagename;
	}
	public String[] update(String line1){
		String line2=update1(line1);
		String[] words=line2.split("\\s+|\\t+");
	  for(int i=0;i<words.length;i++){
		  if(words[i].length()!=0&&!words[i].matches("was|this|is|does"))
			if(words[i].charAt(words[i].length()-1)=='s')
				words[i]=words[i].substring(0,words[i].length()-1);
			
		}
		return words;
	}
	public String update1(String line)
	{	line=line.toLowerCase();
		line = line.replace(",", " ");
		line = line.replace(".", " ");
		line = line.replace(";", " ");
		line = line.replace("!", " ");
    	line = line.replace("?", " ");
    	line = line.replace("#", " ");
    	line = line.replace("'", " ");
    	line = line.replace(":", " ");
    	line = line.replace("-"," ");
    	line = line.replace("{", " ");
    	line = line.replace("}", " ");
    	line = line.replace("(", " ");
    	line = line.replace(")", " ");
    	line = line.replace("[", " ");
    	line = line.replace("]", " ");
    	line = line.replace("<", " ");
    	line = line.replace(">", " ");
    	line = line.replace("=", " ");
    	line = line.replace("\"", " ");
		return line;
	}
}