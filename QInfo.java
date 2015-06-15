public class QInfo

{
	private String text;
	private String[] choice = new String[4];
	private int correct=0;
        private int marked;
        private int number;
        private String section;
        private int volume;
        private int weight=0;


	QInfo()
	{
		for(int x = 0;x < 4;x++)
                {
                  text = "";
                   choice[x] = "";
                }

	}

        public void setChoice(int x, String info)
        {
        choice[x]= info;
        }

        public String getChoice(int x)
        {
        return choice[x];
        }

        public void printChoice()
        {
          for(int x = 0;x < 4;x++)
                {
                  System.out.println(choice[x]);
                }
          }
        public void setText(String body)
        {
        text = body;
        }
        public String getText()
        {
          return text;
          }
        public void printText()
        {

        System.out.println(text);

        }
        public void setCorrect(int x)
        {
          correct = x;
          }
        public int getCorrect()
        {
        return correct;
        }
        public int getMarked()
        {
          return marked;
        }

        public void setMarked(int x)
        {
          marked = x;

        }
        public int getNumber()
        {
          return number;
        }

        public void setNumber(int x)
        {
          number = x;

        }
        public void setSection(String sec)
        {
          section = sec;
        }
        public String getSection()
        {
          return section;
        }
        public void setVolume(int vol)
       {
         volume = vol;
       }
       public int getVolume()
       {
         return volume;
       }




}


